import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: any;
  message: any;

  constructor(
    private auth: AuthenticationService,
    private router: Router
    ) { }

  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        if (res.login[0].role === 'admin') {
          form.reset();
          this.message = res.description;
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);
          localStorage.setItem('userDetails', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/admin');

        } else {
          if (res.login[0].role === 'finance') {
            form.reset();
            this.message = res.description;
            setTimeout(() => {
              this.message = null;
            }, 5000);
            console.log(res);
            localStorage.setItem('userDetails', JSON.stringify(res));
            console.log('user details stored in local storage');
            this.router.navigateByUrl('/addfinance');
          } else {
            form.reset();
            this.message = res.description;
            setTimeout(() => {
              this.message = null;
            }, 5000);
            console.log(res);
            localStorage.setItem('userDetails', JSON.stringify(res));
            console.log('user details stored in local storage');
            this.router.navigateByUrl('/lad');
          }
        }
      } else {
        form.reset();
        this.error = res.error.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      }
    }, err => {
      this.error = err.error.message;
      setTimeout(() => {
        this.error = null;
      }, 3000);
    });
  }

  ngOnInit() {
  }

}
