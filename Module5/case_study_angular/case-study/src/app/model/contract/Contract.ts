import {Customer} from "../customer/Customer";
import {Employee} from "../employee/Employee";
import {Facility} from "../facility/Facility";

export interface Contract {
  id?: number;
  customer?: Customer;
  employee?: Employee;
  facility?: Facility;
  startDate?: Date;
  endDate?:Date;
  deposit?: number;
  status?: boolean;
}
