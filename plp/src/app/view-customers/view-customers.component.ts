import { Component, OnInit } from '@angular/core';
import { CustomersService } from '../customers.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-customers',
  templateUrl: './view-customers.component.html',
  styleUrls: ['./view-customers.component.css']
})
export class ViewCustomersComponent implements OnInit {
 customer: Customers[];
  constructor(private customers: CustomersService,
    private http: HttpClient) {
      this.getcustomer();
     }

    getcustomer(){
      this.customers.getData().subscribe(response =>{
        console.log(response);
        this.customer =  response.customer;
    
      
      });
    }

  ngOnInit() {
  }

}
