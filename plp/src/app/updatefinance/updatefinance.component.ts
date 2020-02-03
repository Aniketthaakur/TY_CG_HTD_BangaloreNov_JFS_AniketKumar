import { Component, OnInit } from '@angular/core';
import { FinanceService } from '../finance.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-updatefinance',
  templateUrl: './updatefinance.component.html',
  styleUrls: ['./updatefinance.component.css']
})
export class UpdatefinanceComponent implements OnInit {

  loanType1;
  loanTerm1;
  loanAmount1;
  interest1;


  constructor(private financeDetails: FinanceService,
    private router: Router,
    activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.loanType);
      this.loanType1 = data.loanType;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.loanTerm1 = data.loanTerm;
      this.loanAmount1 = data.loanAmount;
      this.interest1 = data.interest;

    });
  }

  ngOnInit() {
  }

  updatefinance(form: NgForm) {
    console.log(form.value);
    this.financeDetails.updatefinance(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/viewfinance');
    });
  }


}
