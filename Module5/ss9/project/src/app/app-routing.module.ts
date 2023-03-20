import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductListComponent} from "./component/product/product-list/product-list.component";
import {ProductEditComponent} from "./component/product/product-edit/product-edit.component";
import {ProductCreateComponent} from "./component/product/product-create/product-create.component";
import {FinalListComponent} from "./component/finalmodule/final-list/final-list.component";
import {FinalCreateComponent} from "./component/finalmodule/final-create/final-create.component";
import {FinalEditComponent} from "./component/finalmodule/final-edit/final-edit.component";
import {Final2ListComponent} from "./component/final2/final2-list/final2-list.component";
import {Final2EditComponent} from "./component/final2/final2-edit/final2-edit.component";


const routes: Routes = [
  {
    path: "product-list", component: ProductListComponent
  },
  {
    path: "product/product-edit/:id", component: ProductEditComponent
  },
  {
    path: "product/product-create", component: ProductCreateComponent
  },
  {
    path: "final/final-list", component: FinalListComponent
  },
  {
    path: "final/final-create", component: FinalCreateComponent
  },
  {
    path: "final/final-edit/:id", component: FinalEditComponent
  },
  {
    path: "final2/final2-list", component: Final2ListComponent
  },
  {
    path: "final2/final2-edit/:id", component: Final2EditComponent
  }
  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
