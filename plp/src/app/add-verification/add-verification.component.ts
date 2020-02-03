import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { VerificationService } from '../verification.service';


@Component({
  selector: 'app-add-verification',
  templateUrl: './add-verification.component.html',
  styleUrls: ['./add-verification.component.css']
})
export class AddVerificationComponent implements OnInit {
  success:string;
  failure:string;
  processing= "Not assign";
  constructor(private verification:VerificationService) { }

  ngOnInit() {
  }
  addVerification(form:NgForm) {
    this.verification.addVerification(form.value).subscribe(data => {
      console.log(data);
      if(data.statusCode===201){
        this.success=data.description;
        setTimeout(()=> {
          this.success=null;
        },2000);
        form.reset();
      } else {
        this.failure=data.description;
        setTimeout(()=> {
          this.failure=null;
        },2000);
      }
    });
  
  }

}
