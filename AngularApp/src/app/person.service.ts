import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from './person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private baseUrl = 'http://localhost:8080/';
  constructor(private http: HttpClient) {
  }
  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(`${this.baseUrl}`+'persons');
  }
  public getPersonByPersonalCodeAndBirthDate(personalCode: string, birthDate: string): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'person/' + personalCode +'/' + birthDate);
  }


}
