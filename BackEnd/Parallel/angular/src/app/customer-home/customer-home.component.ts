import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  products: any;

  constructor(private adminService: AdminService,
              private router: Router) { }

  ngOnInit() {
  }
  getProducts() {
    this.adminService.getProduct().subscribe(response => {
      console.log(response);
      this.products = response.product;
    }, err => {
      console.log(err);
    });
  }
  selectProduct(product) {
    this.adminService.selectedProductToBuy = product;
    this.router.navigateByUrl('/order');
  }

}
