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

  constructor(private auth: AuthenticationService,
    private router: Router) { }

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
          localStorage.setItem('userDetails.login[0]', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/');

        } else {
          form.reset();
          this.message = res.description;
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);
          localStorage.setItem('userDetails.login[0]', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/schedular');
        }
      } else {
        form.reset();
        this.error = res.description;
        setTimeout(() => {
          this.error = null;
        }, 5000);

      }

    });
  }

  ngOnInit() {
  }

}
