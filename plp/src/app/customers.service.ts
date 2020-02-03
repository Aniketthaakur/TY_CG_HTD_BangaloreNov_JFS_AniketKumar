import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  selectedProductToUpdate: any;
  customerName;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  postData(customer): Observable<any> {
    return this.http.post<any>(
      `${this.api}/insert-customer`, customer);
  }

  getData() : Observable<any> {
    return this.http.get<any> (`${this.api}/view-customers`);
  }
}
