import {PositionEmployee} from "./PositionEmployee";
import {Education} from "./Education";
import {Division} from "./Division";


export interface Employee {
  id?: number;
  name?: string;
  birthday?: string;
  idCard?: string;
  salary?: number;
  phoneNumber?: string;
  email?: string;
  address?: string;
  positionEmployee?: PositionEmployee;
  education?: Education;
  division?: Division;
}
