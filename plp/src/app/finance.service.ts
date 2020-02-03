import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FinanceService {
  url = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  addFinance(financeDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-finance`, financeDetails);
  }
  
  searchFinance(financeDetails): Observable<any> {
    return this.http.get<any>(`${this.url}/get-finance/${financeDetails.loanType}`, financeDetails);
  }

  getAllFinance(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-finance`);
  }

  deleteFinance(finance: Finance) {
    return this.http.delete<any>(`${this.url}/delete-finance/${finance.loanType}`);
  }

  updatefinance(finance) {
    return this.http.put<any>(`${this.url}/modify-finance`, finance);
  }

}
