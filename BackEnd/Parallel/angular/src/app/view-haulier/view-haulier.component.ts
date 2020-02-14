import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-haulier',
  templateUrl: './view-haulier.component.html',
  styleUrls: ['./view-haulier.component.css']
})
export class ViewHaulierComponent implements OnInit {

  hauliers: any;
  message: any;

  constructor(private adminService: AdminService,
              private router: Router) {
    this.getHauliers();
  }

  ngOnInit() {
  }
  getHauliers() {
    this.adminService.getHaulier().subscribe(response => {
      console.log(response);
      this.hauliers = response.haulier;
    }, err => {
      console.log(err);
    });
  }
  deleteCustomer(haulier) {
    this.adminService.deleteHaulier(haulier).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.hauliers.splice(this.hauliers.indexOf(haulier), 1);
        this.message = res.message;
      }
    });
  }
  deleteMessage() {
    this.message = null;
  }
  selectCustomer(haulier) {
    this.adminService.selectedHaulierToUpdate = haulier;
    this.router.navigateByUrl('/modify-haulier');
  }

}
