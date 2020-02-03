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
    const userDetails = JSON.parse(localStorage.getItem('userDetails.login[0]'));
    if (userDetails && userDetails.login[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isFinance() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.login[0].role === 'finance') {
      return true;
    } else {
      return false;
    }
  }
  isLad() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.login[0].role === 'lad') {
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  logout() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/');
  }
}

