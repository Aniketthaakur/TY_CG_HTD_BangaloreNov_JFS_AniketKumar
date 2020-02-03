import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FinanceService } from '../finance.service';

@Component({
  selector: 'app-get-all-finance',
  templateUrl: './get-all-finance.component.html',
  styleUrls: ['./get-all-finance.component.css']
})
export class GetAllFinanceComponent implements OnInit {

  success: string;
  failure: string;
  finances: Finance[];
  

  constructor(private financeDet: FinanceService,
              private router: Router) {
    this.getAllFinance();
  }

  deleteFinance(finance: Finance) {
    this.financeDet.deleteFinance(finance).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.finances.splice(this.finances.indexOf(finance), 1);
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    })
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
