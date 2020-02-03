import { Component, OnInit } from '@angular/core';
import { FinanceService } from '../finance.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-finance',
  templateUrl: './finance.component.html',
  styleUrls: ['./finance.component.css']
})
export class FinanceComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private finance: FinanceService) { }

  ngOnInit() {
  }

  addFinance(form: NgForm) {
    this.finance.addFinance(form.value).subscribe(data => {
      console.log(data);

      if(data.statusCode === 201){
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 2000);
        form.reset();
      } else {
        this.failure = data.description
        ;
        setTimeout(() => {
          this.failure = null;
        },2000);
      }
    });
  }
}
