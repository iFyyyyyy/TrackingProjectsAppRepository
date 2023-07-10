import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Board } from '../Entities/Board';

@Injectable({
  providedIn: 'root'
})
export class BoardServiceService {

    private studentsUrl = '/api/boards';


    constructor(
      private http: HttpClient) { }

      getAllBoards(): Observable<Board[]> {
        return this.http.get<Board[]>(this.studentsUrl);
      }


    // getAllStudents(): Observable<Student[]> {
    //   return this.http.get<Student[]>(this.studentsUrl
    //     );
    // }

    // getUserInfo(username: string): Observable<Student>{
    //   return this.http.post<Student>(`${this.studentsUrl}/userInfo`, username).pipe();
    // }

    // getStudents(pageIndex: number, pageSize: number) {
    //     return this.http.get<any>(`${this.studentsUrl}?pageIndex=${pageIndex}&pageSize=${pageSize}`);
    //   }

    // addNewStudent(student: Student): Observable<Student> {
    //   console.log('addNewStudent ' + student.fio + " " + student.group);
    //   return this.http.post<Student>(this.studentsUrl, student).pipe();
    // }




    // менять в angular.json
    // "options": {
    //   "browserTarget": "firstApp:build",
    //   "proxyConfig": "src/proxy.conf.json"},
  }

