import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  message: any;
  error: any;
  button = false;
  viewCustomer = false;
  insert = false;
  viewProd = false;
  work=true;
  insertHaul=false;
  customers: any;
  products: any;

  constructor(private router: Router,
              private customerService: CustomerService,
              private adminService: AdminService) {
    
    
  }

  ngOnInit() {
  }
  // addCustomer(form: NgForm) {
  //   this.customerService.postData(form.value).subscribe(data => {
  //     if (data.statusCode === 201){
  //       console.log(data);
  //       this.message = data.message;
  //     } else{
  //       console.log(data);
  //       this.error = data.message;
  //     }
  //     setTimeout(() => {
  //       this.message = null;
  //     }, 2000);
  //     form.reset();
  //   });
  // }
  insertHaulier(){

    this.work=false;
    this.insert = false;
    this.viewProd = false;
    this.viewCustomer = false;
    this.button = false;
    this.insertHaul=true;
  }
  add(){
    this.insertHaul=false;
    this.work=false;
    this.insert = false;
    this.viewProd = false;
    this.viewCustomer = false;
    this.button = true;
  }
  view(){
    this.router.navigateByUrl('/view-customer')
  }
  insertProduct(){
    this.insertHaul=false;
    this.work=false;
    this.viewProd = false;
    this.viewCustomer = false;
    this.button = false;
    this.insert = true;
  }
  addProduct(form: NgForm) {
    this.adminService.postProduct(form.value).subscribe(data => {
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
  viewProduct() {
    this.router.navigateByUrl('/view-product')
  }
  addHaulier(form: NgForm) {
    this.adminService.postHaulier(form.value).subscribe(data => {
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
  viewHaulier() {
    this.router.navigateByUrl('/view-haulier')
  }

}
