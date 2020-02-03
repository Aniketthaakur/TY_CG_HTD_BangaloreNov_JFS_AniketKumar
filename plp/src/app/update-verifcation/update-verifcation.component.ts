import { Component, OnInit } from '@angular/core';
import { VerificationService } from '../verification.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-verifcation',
  templateUrl: './update-verifcation.component.html',
  styleUrls: ['./update-verifcation.component.css']
})
export class UpdateVerifcationComponent implements OnInit {
status:Response
verificationIds;
applicationIds ;
interviewDates;
statuses;
loanType;

  constructor(private verificationDet: VerificationService,
    private router: Router,private activatedRoute:ActivatedRoute) { 
      activatedRoute.params.subscribe(data=> {
        console.log(data.productId);
        this.verificationIds=data.verificationId;
      });
    }
    modifyVerification(form: NgForm) {
      this.verificationDet.modifyVerification(form.value).subscribe(data => {
        console.log(data);
        
        if(data.statusCode===201) {
          this.router.navigateByUrl('/get-all-verification');
        }
      })
    } 

  ngOnInit() {
  }

}
