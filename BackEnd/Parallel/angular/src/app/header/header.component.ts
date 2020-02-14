import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.login[0]'));
    if (userDetails && userDetails.login[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isSchedular() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.login[0]'));
    if (userDetails && userDetails.login[0].role === 'schedular') {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.login[0]'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }

  }
  isLoggedInCustomer(){
    let userDetails = JSON.parse(localStorage.getItem('customerDetails.customer[0]'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  logout() {
    localStorage.removeItem('userDetails.login[0]');
    localStorage.removeItem('customerDetails.customer[0]');
    this.router.navigateByUrl('/');
    
  }
  navigate(){
    this.router.navigateByUrl('/view-order');
  }
}
