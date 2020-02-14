import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html',
  styleUrls: ['./modify-product.component.css']
})
export class ModifyProductComponent implements OnInit {
  message: any;
  prod;

  constructor(private adminService: AdminService,
              private router: Router,) {
                this.prod=adminService.selectedProductToUpdate;
               }

  ngOnInit() {
  }
  updateProduct(form: NgForm) {
    
    this.adminService.updateProduct(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.message;
        localStorage.setItem('product', JSON.stringify(res));
        this.router.navigateByUrl('/view-product');
        setTimeout(() => {
          this.message=null;
        }, 5000);
        form.reset();
      }
    });
  }

}
