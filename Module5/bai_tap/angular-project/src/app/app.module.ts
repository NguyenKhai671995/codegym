import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Ss3CalculatorComponent } from './ss3-calculator/ss3-calculator.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Ss3ColorpickerComponent } from './ss3-colorpicker/ss3-colorpicker.component';
import { Ss6RegisterComponent } from './ss6-register/ss6-register.component';
import { Ss7ProductComponent } from './ss7-product/ss7-product.component';
import { ProductListComponent } from './ss7-product/product-list/product-list.component';
import { ProductCreateComponent } from './ss7-product/product-create/product-create.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductEditComponent } from './ss7-product/product-edit/product-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    Ss3CalculatorComponent,
    Ss3ColorpickerComponent,
    Ss6RegisterComponent,
    Ss7ProductComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,

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
