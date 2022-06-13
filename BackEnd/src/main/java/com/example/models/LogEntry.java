package com.example.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String methodName;

    @Column
    private String ipAddress;

    @Column
    private String requestTarget;

    @Column
    private LocalDateTime requestTime;
}
