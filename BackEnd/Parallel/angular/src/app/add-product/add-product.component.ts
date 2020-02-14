import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { AdminService } from '../admin.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  message: any;
  error: any;

  constructor(private router: Router,
    private customerService: CustomerService,
    private adminService: AdminService) {


}

  ngOnInit() {
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
}
