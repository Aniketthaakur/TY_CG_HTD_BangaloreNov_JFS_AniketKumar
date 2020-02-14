import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customers: any;
  message: any;

  constructor(private customerService: CustomerService,
              private router: Router) {
    this.getCustomers();
  }

  ngOnInit() {
  }
  getCustomers() {
    this.customerService.getData().subscribe(response => {
      console.log(response);
      this.customers = response.customer;
    }, err => {
      console.log(err);
    });
  }
  deleteCustomer(customer) {
    this.customerService.deleteData(customer).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.customers.splice(this.customers.indexOf(customer), 1);
        this.message = res.message;
      }
    });
  }
  deleteMessage() {
    this.message = null;
  }
  selectCustomer(customer) {
    this.customerService.selectedProductToUpdate = customer;
    this.router.navigateByUrl('/modify-customer');
  }

}
