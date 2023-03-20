import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductListComponent} from './ss7-product/product-list/product-list.component';
import {ProductCreateComponent} from './ss7-product/product-create/product-create.component';
import {ProductEditComponent} from './ss7-product/product-edit/product-edit.component';
import {Ss3CalculatorComponent} from "./ss3-calculator/ss3-calculator.component";
import {Ss3ColorpickerComponent} from "./ss3-colorpicker/ss3-colorpicker.component";
import {Ss6RegisterComponent} from "./ss6-register/ss6-register.component";


const routes: Routes = [{
    path: 'ss3-calculator', component: Ss3CalculatorComponent
  }, {
    path: 'ss3-color', component: Ss3ColorpickerComponent
  },
    {
      path: 'ss6', component: Ss6RegisterComponent
    },
    {
      path: 'list', component: ProductListComponent
    },
    {
      path: 'create', component: ProductCreateComponent
    },
    {
      path: 'list/edit/:id', component: ProductEditComponent
    }

  ]
;


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
