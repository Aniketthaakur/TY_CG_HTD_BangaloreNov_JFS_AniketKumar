import { Component, OnInit } from '@angular/core';
import { StatusService } from '../status.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-status',
  templateUrl: './get-all-status.component.html',
  styleUrls: ['./get-all-status.component.css']
})
export class GetAllStatusComponent implements OnInit {

  
  ngOnInit() {
  }
  success: string;
  failure: string;
  statuses: Status[];
  
  constructor(private statusDet: StatusService,
    private router: Router) { 
      this.getStatus();

    }
    deleteStatus(status : Status) {
      this.statusDet.deleteStatus(status).subscribe(data => {
        console.log(data);
        if(data.statusCode===201) {
          this.statuses.splice(this.statuses.indexOf(status),1);
          this.success=data.status;
          setTimeout(() => {
            this.success= null;
          },2000)
        }
      });
    }
    modifyStatus(status) {
      this.router.navigate([`modify-status/${status.statusId}`],
      {
        queryParams:{
          applicationId:status.applicationId,
          status:status.status,
          loanType:status.loanType
  
        }
      }
      );
        }  
    getStatus() {
      this.statusDet.getStatus().subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          this.statuses = response.status;
          this.success = response.description;
          localStorage.setItem('Status Details', JSON.stringify(response));
          setTimeout(() => {
            this.success = null;
          }, 2000);
  
        } else {
          this.failure = response.description;
          localStorage.setItem('status Details', JSON.stringify(response));
          console.log('Status Details are Added');
          setTimeout(() => {
            this.failure = null;
          }, 2000);
        }
      })
    }
}
