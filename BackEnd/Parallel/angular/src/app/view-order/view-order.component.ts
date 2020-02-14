import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {

  orders;
  contracts;
  message: any;

  constructor(private adminService: AdminService) {
    this.getOrders();
    this.getContract();
   }

  ngOnInit() {
  }
  getOrders() {
    this.adminService.getOrder().subscribe(response => {
      console.log(response);
      this.orders = response.order;
    }, err => {
      console.log(err);
    });
  }
  getContract() {
    this.adminService.getContractRequest().subscribe(response => {
      console.log(response);
      this.contracts = response.contractRequest;
    }, err => {
      console.log(err);
    });
  }
  deleteOrder(order) {
    this.adminService.deleteOrder(order).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.orders.splice(this.orders.indexOf(order), 1);
        this.message = res.message;
      }
    });
  }
}
