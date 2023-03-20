import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { HomeComponent } from './component/home/home.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { EmployeeListComponent } from './component/employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employee/employee-create/employee-create.component';
import { EmployeeEditComponent } from './component/employee/employee-edit/employee-edit.component';
import { FacilityListComponent } from './component/facility/facility-list/facility-list.component';
import { FacilityUpdateComponent } from './component/facility/facility-update/facility-update.component';
import { FacilityDetailComponent } from './component/facility/facility-detail/facility-detail.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import { ContractUpdateComponent } from './component/contract/contract-update/contract-update.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    FacilityListComponent,
    FacilityUpdateComponent,
    FacilityDetailComponent,
    ContractListComponent,
    ContractUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
