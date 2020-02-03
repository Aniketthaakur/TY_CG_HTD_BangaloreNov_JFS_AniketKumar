import { Component, OnInit } from '@angular/core';
import { CustomersService } from '../customers.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  message: string;
  constructor(private customers: CustomersService,
    private http: HttpClient) { }

  addCustomer(form: NgForm) {
    this.customers.postData(form.value).subscribe(response => {
      console.log(response);
      if(response.statusCode===201){
      this.message = response.message;
      setTimeout(() => {
        this.message = null;
      }, 5000);
      form.reset();
    }else{
     description => {
      console.log(description);
    }
  }
    });

  }

  ngOnInit() {
  }

}
