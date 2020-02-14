import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  selectedOrderToContract;
  selectedOrderToUpdate;
  selectedProductToUpdate;
  selectedHaulierToUpdate;
  selectedProductToBuy;
  api = `http://localhost:8080/forestrymanagementsystemspringrest`;

  constructor(private http: HttpClient) { }

  postProduct(product): Observable<any> {

    return this.http.post<any>(`${this.api}/add-product`, product);
  }
  getProduct(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-product`);
  }
  deleteProduct(product: any): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-product/${product.productId}`);
  }
  updateProduct(product): Observable<any> {
    return this.http.put<any>(
      `${this.api}/modify-product`,
      product);
  }
  postHaulier(haulier): Observable<any> {

    return this.http.post<any>(`${this.api}/add-haulier`, haulier);
  }
  getHaulier(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-haulier`);
  }
  deleteHaulier(haulier: any): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-haulier/${haulier.hailierId}`);
  }
  updateHaulier(haulier): Observable<any> {
    return this.http.put<any>(
      `${this.api}/modify-haulier`,
      haulier);
  }
  postOrder(order): Observable<any> {
    return this.http.post<any>(`${this.api}/add-order`, order);
  }
  getOrder(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-order`);
  }
  postContractRequest(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-contract-request`, request);
  }
  getContractRequest(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-contract-request`);
  }
  updateContractRequest(request): Observable<any> {
    return this.http.put<any>(
      `${this.api}/modify-contract-request`,
      request);
  }
  deleteOrder(order): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-order/${order.orderId}`);
  }
  updateOrder(order): Observable<any>{
    return this.http.put<any>(`${this.api}/modify-order`, order);
  }
  postContract(contract): Observable<any> {
    return this.http.post<any>(`${this.api}/add-contract`, contract, {headers: new HttpHeaders({'content-type': 'application/json'})});
  }
  getContract(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-contract`);
  }
}
