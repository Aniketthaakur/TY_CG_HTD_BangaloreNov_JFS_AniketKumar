import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { StatusService } from '../status.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {
status:Response
statusIds;
applicationIds ;
statuses;
loanType;

  constructor(private statusDet: StatusService,
    private router: Router,private activatedRoute:ActivatedRoute) {
      activatedRoute.params.subscribe(data=> {
        console.log(data.productId);
        this.statusIds=data.statusId;
      });
     }
     modifyStatus(form: NgForm) {
      this.statusDet.modifyStatus(form.value).subscribe(data => {
        console.log(data);
        
        if(data.statusCode===201) {
          this.router.navigateByUrl('/get-all-status');
        }
      })
    } 

  ngOnInit() {
  }

}
