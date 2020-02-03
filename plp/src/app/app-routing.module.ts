import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GetAllFinanceComponent } from './get-all-finance/get-all-finance.component';
import { FinanceComponent } from './finance/finance.component';
import { UpdatefinanceComponent } from './updatefinance/updatefinance.component';
import { CustomersComponent } from './customers/customers.component';
import { ViewCustomersComponent } from './view-customers/view-customers.component';
import { GetAllStatusComponent } from './get-all-status/get-all-status.component';
import { GetAllVerificationComponent } from './get-all-verification/get-all-verification.component';
import { LadComponent } from './lad/lad.component';
import { AddStatusComponent } from './add-status/add-status.component';
import { AddVerificationComponent } from './add-verification/add-verification.component';
import { ViewFinanceComponent } from './view-finance/view-finance.component';
import { GetVerificationComponent } from './get-verification/get-verification.component';
import { UpdateVerifcationComponent } from './update-verifcation/update-verifcation.component';


const routes: Routes = [
  { path: '', component: HomeComponent },

  { path: 'login', component: LoginComponent },
  {
    path: 'admin', component: AdminComponent
  },
  {
    path: 'viewfinance', component: GetAllFinanceComponent
  },
  {path: 'getfinance',component: ViewFinanceComponent},
  { path: 'addcustomer', component: CustomersComponent },
  { path: 'viewcustomer', component: ViewCustomersComponent },
  { path: 'get-all-verification', component: GetAllVerificationComponent },
  { path: 'get-all-status', component: GetAllStatusComponent },
  { path: 'addfinance', component: FinanceComponent },
  {path: 'lad',component: LadComponent},
  { path: 'updatefinance/:loanType', component: UpdatefinanceComponent },
  {path: 'addstatus',component: AddStatusComponent},
  {path: 'addverification',component: AddVerificationComponent},
  {path: 'getverification' ,component: GetVerificationComponent},
  {path: 'modify-verification/:verificationId',component: UpdateVerifcationComponent},
  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
