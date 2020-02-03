import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AdminComponent } from './admin/admin.component';
import { GetAllFinanceComponent } from './get-all-finance/get-all-finance.component';
import { FinanceComponent } from './finance/finance.component';
import { UpdatefinanceComponent } from './updatefinance/updatefinance.component';
import { LadComponent } from './lad/lad.component';
import { CustomersComponent } from './customers/customers.component';
import { ViewCustomersComponent } from './view-customers/view-customers.component';
import { GetAllVerificationComponent } from './get-all-verification/get-all-verification.component';
import { GetAllStatusComponent } from './get-all-status/get-all-status.component';
import { AddStatusComponent } from './add-status/add-status.component';
import { AddVerificationComponent } from './add-verification/add-verification.component';
import { ViewFinanceComponent } from './view-finance/view-finance.component';
import { GetVerificationComponent } from './get-verification/get-verification.component';
import { GetStatusComponent } from './get-status/get-status.component';
import { UpdateVerifcationComponent } from './update-verifcation/update-verifcation.component';
import { GetLoanProgramComponent } from './get-loan-program/get-loan-program.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    PageNotFoundComponent,
    AdminComponent,
    GetAllFinanceComponent,
    FinanceComponent,
    UpdatefinanceComponent,
    LadComponent,
    CustomersComponent,
    ViewCustomersComponent,
    GetAllVerificationComponent,
    GetAllStatusComponent,
    AddStatusComponent,
    AddVerificationComponent,
    ViewFinanceComponent,
    GetVerificationComponent,
    GetStatusComponent,
    UpdateVerifcationComponent,
    GetLoanProgramComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
