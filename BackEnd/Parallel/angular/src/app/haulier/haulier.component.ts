import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { AdminService } from '../admin.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-haulier',
  templateUrl: './haulier.component.html',
  styleUrls: ['./haulier.component.css']
})
export class HaulierComponent implements OnInit {
  message: any;
  error: any;

  constructor(private router: Router,
    private customerService: CustomerService,
    private adminService: AdminService) {


}

  ngOnInit() {
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
}
