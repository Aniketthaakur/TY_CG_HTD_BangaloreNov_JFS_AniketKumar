import { Component, OnInit } from '@angular/core';
import { FinanceService } from '../finance.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-finance',
  templateUrl: './view-finance.component.html',
  styleUrls: ['./view-finance.component.css']
})
export class ViewFinanceComponent implements OnInit {

  success: string;
  failure: string;
  finances: Finance[];
  

  constructor(private financeDet: FinanceService,
              private router: Router) {
    this.getAllFinance();
  }

  
  getAllFinance() {
    this.financeDet.getAllFinance().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.finances = response.financeProviderResponse;
        this.success = response.description;
        localStorage.setItem('Finance Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);

      } else {
        this.failure = response.description;
        localStorage.setItem('finance Details', JSON.stringify(response));
        console.log('finance Details are Added');
        setTimeout(() => {
          this.failure = null;
        }, 2000);
      }
    })
  }

  ngOnInit() {
  }

  updatefinance(finance) {
    
    this.router.navigate([`updatefinance/${finance.loanType}`],
      {
        queryParams: {
          loanType: finance.loanType,
          loanTerm: finance.loanTerm,
          loanAmount: finance.loanAmount,
          interest: finance.interest,
          

        }
      });
  }


}
