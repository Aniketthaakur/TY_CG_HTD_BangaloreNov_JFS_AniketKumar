import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  selectedProductToUpdate: any;
  customerName;
  api = `http://localhost:8080/forestrymanagementsystemspringrest`;

  constructor(private http: HttpClient) { }

  postData(customerDetails): Observable<any> {

    return this.http.post<any>(`${this.api}/add-customer`, customerDetails);
  }
  getData(): Observable <any>{
    return this.http.get<any>(`${this.api}/get-customer`);
  }
  deleteData(customer: any): Observable<any>{
    return this.http.delete<any>(`${this.api}/delete-customer/${customer.custid}`);
  }
  updateData(customer): Observable<any>{
    return this.http.put<any>(
      `${this.api}/modify-customer`,
      customer);
  }
}
