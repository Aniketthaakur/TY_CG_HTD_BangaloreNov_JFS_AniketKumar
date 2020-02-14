import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-order',
  templateUrl: './modify-order.component.html',
  styleUrls: ['./modify-order.component.css']
})
export class ModifyOrderComponent implements OnInit {
  order: any;
  message: any;
  today = Date.now();

  
  constructor(private adminService: AdminService,
              private router: Router,) {
      this.order = adminService.selectedOrderToUpdate;
     }

ngOnInit() {
}
updateOrder(form: NgForm) {

this.adminService.updateOrder(form.value).subscribe(res => {
console.log(res);
if (res.statusCode === 201) {
this.message = res.message;
localStorage.setItem('order', JSON.stringify(res));
this.router.navigateByUrl('/schedular');
setTimeout(() => {
this.message = null;
}, 5000);
form.reset();
}
});
}

}
