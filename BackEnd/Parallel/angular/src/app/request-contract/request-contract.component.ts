import { Component, OnInit } from '@angular/core';
import { SourceAndMapMixin } from 'webpack-sources';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-request-contract',
  templateUrl: './request-contract.component.html',
  styleUrls: ['./request-contract.component.css']
})
export class RequestContractComponent implements OnInit {

  contract;
  message: any;
  constructor(private adminService: AdminService,
              private router: Router) {
               this.contract = adminService.selectedOrderToContract;
  }

  ngOnInit() {
  }
  addRequest(form: NgForm) {
    
    this.adminService.postContractRequest(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.message;
        localStorage.setItem('product', JSON.stringify(res));
        this.router.navigateByUrl('/view-order');
        setTimeout(() => {
          this.message=null;
        }, 5000);
        form.reset();
      }
    });
  }

}
