import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  message: any;
  error: any;


  constructor(private router: Router,
              private customerService: CustomerService,
              private adminService: AdminService) {


  }

  ngOnInit() {
  }
  addCustomer(form: NgForm) {
    this.customerService.postData(form.value).subscribe(data => {
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
