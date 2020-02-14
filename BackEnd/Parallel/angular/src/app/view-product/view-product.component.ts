import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {
  products: Product[];
  message: any;

  constructor(private adminService: AdminService,
              private router: Router) {
    this.getProducts();
  }

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
  deleteProduct(product: Product) {
    this.adminService.deleteProduct(product).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.products.splice(this.products.indexOf(product), 1);
        this.message = res.message;
      }
    });
  }
  deleteMessage() {
    this.message = null;
  }
  selectProduct(product: Product) {
    this.adminService.selectedProductToUpdate = product;
    this.router.navigateByUrl('/modify-product');
  }
}
