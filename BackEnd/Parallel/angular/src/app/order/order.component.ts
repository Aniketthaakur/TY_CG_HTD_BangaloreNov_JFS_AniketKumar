import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerLoginComponent } from '../customer-login/customer-login.component';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  prod;
  cust;
  message: any;
  error: any;

  constructor(private adminService: AdminService,
              private router: Router,
              private customerService: CustomerService
              ) {
              this.prod = adminService.selectedProductToBuy;
              
  }
  ngOnInit() {
  }
  buyProduct(form: NgForm) {
    this.adminService.postOrder(form.value).subscribe(data => {
      if (data.statusCode === 201) {
        console.log(data);
        this.message = data.message;
      } else {
        console.log(data);
        this.error = data.message;
      }
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    });
  }
}