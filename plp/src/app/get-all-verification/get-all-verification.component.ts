import { Component, OnInit } from '@angular/core';
import { VerificationService } from '../verification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-verification',
  templateUrl: './get-all-verification.component.html',
  styleUrls: ['./get-all-verification.component.css']
})
export class GetAllVerificationComponent implements OnInit {

  ngOnInit() {
  }
  success: string;
  failure: string;
  verifications: Verification[];

  constructor(private verificationDet: VerificationService,
              private router: Router) {
    this.getVerifications();
  }
  deleteVerification(verification : Verification) {
    this.verificationDet.deleteVerification(verification).subscribe(data => {
      console.log(data);
      if(data.statusCode===201) {
        this.verifications.splice(this.verifications.indexOf(verification),1);
        this.success=data.verification;
        setTimeout(() => {
          this.success= null;
        },2000)
      }
    });
  }
  getVerifications() {
    this.verificationDet.getVerifications().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.verifications = response.verification;
        this.success = response.description;
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
  modifyVerification(verification) {
    this.router.navigate([`modify-verification/${verification.verificationId}`],
    {
      queryParams:{
        applicationId:verification.applicationId,
        interviewDate:verification.deliveryDate,
        status:verification.status,
        loanType:verification.loanType

      }
    }
    );
      }

}
