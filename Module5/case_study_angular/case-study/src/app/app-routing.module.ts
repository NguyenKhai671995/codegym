import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from "./component/customer/customer-list/customer-list.component";
import {HomeComponent} from "./component/home/home.component";
import {CustomerCreateComponent} from "./component/customer/customer-create/customer-create.component";
import {CustomerEditComponent} from "./component/customer/customer-edit/customer-edit.component";
import {EmployeeListComponent} from "./component/employee/employee-list/employee-list.component";
import {EmployeeCreateComponent} from "./component/employee/employee-create/employee-create.component";
import {EmployeeEditComponent} from "./component/employee/employee-edit/employee-edit.component";
import {FacilityListComponent} from "./component/facility/facility-list/facility-list.component";
import {FacilityDetailComponent} from "./component/facility/facility-detail/facility-detail.component";
import {FacilityUpdateComponent} from "./component/facility/facility-update/facility-update.component";
import {ContractListComponent} from "./component/contract/contract-list/contract-list.component";
import {ContractUpdateComponent} from "./component/contract/contract-update/contract-update.component";


const routes: Routes = [
  {
    path: "", component: HomeComponent
  },
  //Customer
  {
    path: "customer/customer-list", component: CustomerListComponent
  },
  {
    path: "customer/customer-create", component: CustomerCreateComponent
  } ,
  {
    path: "customer/customer-edit/:id",component: CustomerEditComponent

  },
  //Employee
  {
    path: "employee/employee-list",component: EmployeeListComponent

  },
  {
    path: "employee/employee-create", component: EmployeeCreateComponent
  },
  {
    path: "employee/employee-edit/:id",component: EmployeeEditComponent
  },
  //facility
  {
    path: "facility/facility-list",component: FacilityListComponent
  },{
    path: "facility/facility-detail/:id",component: FacilityDetailComponent
  },{
    path: "facility/facility-update",component: FacilityUpdateComponent
  },{
    path: "facility/facility-edit/:id",component: FacilityUpdateComponent
  },
  {
    path:"contract/contract-list",component: ContractListComponent
  },
  {
    path: "contract/contract-create",component: ContractUpdateComponent
  },{
    path: "contract/contract-edit/:id",component: ContractUpdateComponent
  },




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
