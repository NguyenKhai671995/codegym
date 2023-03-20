import {Component, OnInit} from '@angular/core';
import {Employee} from "../../../model/employee/Employee";
import {Facility} from "../../../model/facility/Facility";
import {RentType} from "../../../model/facility/RenType";
import {FacilityType} from "../../../model/facility/FacilityType";
import {FacilityService} from "../../../service/facility/facility.service";
import {RenTypeService} from "../../../service/facility/ren-type.service";
import {FacilityTypeService} from "../../../service/facility/facility-type.service";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilitys: Facility[] = [];
  renTypes: RentType[] = [];
  facilityTypes: FacilityType[] = [];
  facilitySelect: Facility = {};

  constructor(private facilityService: FacilityService,
              private renTypeService: RenTypeService,
              private facilityTypeService: FacilityTypeService
  ) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  private findAll() {
    this.renTypes = this.renTypeService.findALl();
    this.facilityTypes = this.facilityTypeService.findALl();

    this.facilityService.findALl().subscribe(data => {
      console.log(data)
      this.facilitys = data.content;
    })
  }

  wantDeleteIt(facility: Facility) {
    this.facilitySelect = facility;
  }

  deleteThis(id: number) {
    this.facilityService.deleteById(id).subscribe(data => {
      this.facilitySelect = {};
      alert("delete ok");
      document.getElementById("deleteModal").click();
      this.ngOnInit();
    })
  }

}
