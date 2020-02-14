import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-schedular',
  templateUrl: './schedular.component.html',
  styleUrls: ['./schedular.component.css']
})
export class SchedularComponent implements OnInit {
  products: any;
  productButton = false;
  orderButton = false;
  haulierButton = false;
  customerButton = false;
  contractRequestButton = true;
  addContractButton = false;
  orders: any;
  hauliers: any;
  customers: any;
  contracts: any;
  message: any;
  error: any;

  constructor(private adminService: AdminService,
              private router: Router,
              private customerService: CustomerService) {
    this.getProducts();
    this.getOrders();
    this.getHauliers();
    this.getCustomers();
    this.getContract();
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
  viewProduct() {
    this.customerButton = false;
    this.contractRequestButton = false;
    this.addContractButton = false;
    this.haulierButton = false;
    this.orderButton = false;
    this.productButton = true;
  }
  viewOrder() {
    this.customerButton = false;
    this.contractRequestButton = false;
    this.addContractButton = false;
    this.haulierButton = false;
    this.productButton = false;
    this.orderButton = true;
  }
  viewHaulier() {
    this.customerButton = false;
    this.contractRequestButton = false;
    this.addContractButton = false;
    this.productButton = false;
    this.orderButton = false;
    this.haulierButton = true;
  }
  viewCustomer(){
    this.contractRequestButton = false;
    this.addContractButton = false;
    this.productButton = false;
    this.orderButton = false;
    this.haulierButton = false;
    this.customerButton = true;
  }
  getOrders() {
    this.adminService.getOrder().subscribe(response => {
      console.log(response);
      this.orders = response.order;
    }, err => {
      console.log(err);
    });
  }
  update(order) {
    this.adminService.selectedOrderToUpdate = order;
    this.router.navigateByUrl('/modify-order');
  }
  getHauliers() {
    this.adminService.getHaulier().subscribe(response => {
      console.log(response);
      this.hauliers = response.haulier;
    }, err => {
      console.log(err);
    });
  }
  getCustomers() {
    this.customerService.getData().subscribe(response => {
      console.log(response);
      this.customers = response.customer;
    }, err => {
      console.log(err);
    });
  }
  viewContractRequest() {
    this.customerButton = false;
    this.addContractButton = false;
    this.productButton = false;
    this.orderButton = false;
    this.haulierButton = false;
    this.contractRequestButton = true;

  }
  addContract() {
    this.customerButton = false;
    this.contractRequestButton = false;
    this.productButton = false;
    this.orderButton = false;
    this.haulierButton = false;
    this.addContractButton = true;
  }
  updateContractRequest(form: NgForm, contract) {

    this.adminService.updateContractRequest(form.value).subscribe(res => {
    console.log(res);
    if (res.statusCode === 201) {
      this.delete(contract);
    }
    });
    }
    delete(contract) {
          this.contracts.splice(this.contracts.indexOf(contract), 1);
    }
    getContract() {
      this.adminService.getContractRequest().subscribe(response => {
        console.log(response);
        this.contracts = response.contractRequest;
      }, err => {
        console.log(err);
      });
    }
    postContract(form: NgForm) {
      this.adminService.postContract(form.value).subscribe(data => {
        if (data.statusCode === 201) {
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
    viewContract(){
      this.router.navigateByUrl('/view-admin-contract');
    }
    
}
