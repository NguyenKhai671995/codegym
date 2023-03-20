import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ProductListComponent } from './component/product/product-list/product-list.component';
import { ProductCreateComponent } from './component/product/product-create/product-create.component';
import { ProductEditComponent } from './component/product/product-edit/product-edit.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { FinalListComponent } from './component/finalmodule/final-list/final-list.component';
import { FinalCreateComponent } from './component/finalmodule/final-create/final-create.component';
import { FinalEditComponent } from './component/finalmodule/final-edit/final-edit.component';
import { Final2ListComponent } from './component/final2/final2-list/final2-list.component';
import { Final2EditComponent } from './component/final2/final2-edit/final2-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    FinalListComponent,
    FinalCreateComponent,
    FinalEditComponent,
    Final2ListComponent,
    Final2EditComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
