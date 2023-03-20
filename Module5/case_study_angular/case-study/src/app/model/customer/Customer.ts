import {CustomerType} from "./Customer-type";

export interface Customer {
  id?: number;
  customerType?: CustomerType;
  name?: string;
  birthday?: string;
  gender?: string;
  idCard?: string;
  phone?: string;
  email?: string;
  address?: string;
  status?: boolean;
}
