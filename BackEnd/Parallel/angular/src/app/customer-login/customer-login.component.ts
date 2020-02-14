import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  error: any;
  message: any;
  navigator = true;
  custRegister = false;

  constructor(private auth: AuthenticationService,
              private router: Router,
              private customerService: CustomerService) { 
              }

  login(form: NgForm) {
    this.auth.loginClient(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.customerService.customerName = res.customer[0].cname;
        form.reset();
        this.message = res.message;
        setTimeout(() => {
          this.message = null;
        }, 5000);
        console.log(res);
        localStorage.setItem('customerDetails.customer[0]', JSON.stringify(res));
        console.log('user details stored in local storage');
        this.router.navigateByUrl('/');
      } else {
        form.reset();
        this.error = res.description;
        setTimeout(() => {
          this.error = null;
        }, 5000);

      }
    });
  }
  ngOnInit() {
  }
  navigate(){
    this.custRegister = true;
    this.navigator = false;
  }
  loginNavigate(){
    this.custRegister = false;
    this.navigator = true;
  }
  addCustomer(form: NgForm) {
    this.customerService.postData(form.value).subscribe(data => {
      if (data.statusCode === 201){
        console.log(data);
        this.message = data.message;
      } else{
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
