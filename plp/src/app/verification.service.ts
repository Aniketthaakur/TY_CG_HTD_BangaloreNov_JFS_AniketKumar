import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VerificationService {
  url=`http://localhost:8080`;


  constructor(private http: HttpClient) { }
  verificationModify:Verification;

  addVerification(verificationDetails) : Observable<any> {
    return this.http.post<any>(`${this.url}/insert-verification`,verificationDetails);
  }
  getVerifications(): Observable<any>{
    return this.http.get<any>(`${this.url}/view-verfications`);
  }
  deleteVerification(verification: Verification){
   return this.http.delete<any>(`${this.url}/delete-customer/${verification.verificationId}`);
  }
  modifyVerification(verificationDetails){
    return this.http.put<any>(`${this.url}/modify-verification`,verificationDetails);
  }
}
