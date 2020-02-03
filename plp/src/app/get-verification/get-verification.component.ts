import { Component, OnInit } from '@angular/core';
import { VerificationService } from '../verification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-verification',
  templateUrl: './get-verification.component.html',
  styleUrls: ['./get-verification.component.css']
})
export class GetVerificationComponent implements OnInit {
  success: string;
  failure: string;
  verifications: Verification[];

  constructor(private verificationDet: VerificationService,
              private router: Router) {
    this.getVerifications();
  }
  getVerifications() {
    this.verificationDet.getVerifications().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.verifications = response.verification;
        this.success = response.verification;
        localStorage.setItem('Verification Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);

      } else {
        this.failure = response.description;
        localStorage.setItem('Verification Details', JSON.stringify(response));
        console.log('Verification Details are Added');
        setTimeout(() => {
          this.failure = null;
        }, 2000);
      }
    })
  }
  ngOnInit() {
  }

}
