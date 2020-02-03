import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  url=`http://localhost:8080`;

  constructor(private http: HttpClient) { }
  addStatus(statusDetails) : Observable<any> {
    return this.http.post<any>(`${this.url}/insert-status`,statusDetails);
  }
  getStatus(): Observable<any>{
    return this.http.get<any>(`${this.url}/view-status`);
  }
  deleteStatus(status: Status){
    return this.http.delete<any>(`${this.url}/delete-status/${status.statusId}`);
   }
   modifyStatus(statusDetails){
     return this.http.put<any>(`${this.url}/modify-status`,statusDetails);
   }
}
