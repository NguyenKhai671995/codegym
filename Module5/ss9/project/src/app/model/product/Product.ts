import {Category} from "./Category";

export interface Product {
  id? : number;
  name? : string;
  dateOfBirth? : Date ;
  email? : string;
  phone? : number;
  manufacture? : string;
  category? : Category;
}
