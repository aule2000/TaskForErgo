package com.example.interceptors;

import com.example.models.LogEntry;
import com.example.repositories.LogRepository;
import com.example.services.SpringContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        HandlerMethod method = (HandlerMethod) handler;
        String methodName = method.getMethod().toString();
        String ipAddress = getRemoteAddr(request);
        String requestTargetUri = request.getRequestURI();
        LocalDateTime requestTime = LocalDateTime.now();

        LogRepository logRepository = SpringContext.getBean(LogRepository.class);
        logRepository.save(LogEntry.builder()
                .requestTime(requestTime)
                .ipAddress(ipAddress)
                .requestTarget(requestTargetUri)
                .methodName(methodName)
                .build());
        return true;
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            System.out.println("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
