import { Component, OnInit } from '@angular/core';
import { StatusService } from '../status.service';
import { NgForm } from '@angular/forms';
import { CustomersService } from '../customers.service';

@Component({
  selector: 'app-add-status',
  templateUrl: './add-status.component.html',
  styleUrls: ['./add-status.component.css']
})
export class AddStatusComponent implements OnInit {
  success:string;
  failure:string;

  constructor(private status:StatusService,
    private customer:CustomersService) { }

  ngOnInit() {
  }
  addStatus(form:NgForm) {
    this.status.addStatus(form.value).subscribe(data => {
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
