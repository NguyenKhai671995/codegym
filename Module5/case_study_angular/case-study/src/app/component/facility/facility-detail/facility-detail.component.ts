import { Component, OnInit } from '@angular/core';
import {FacilityService} from "../../../service/facility/facility.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Facility} from "../../../model/facility/Facility";
import {FacilityTypeService} from "../../../service/facility/facility-type.service";
import {FacilityType} from "../../../model/facility/FacilityType";
import {RentType} from "../../../model/facility/RenType";
import {RenTypeService} from "../../../service/facility/ren-type.service";

@Component({
  selector: 'app-facility-detail',
  templateUrl: './facility-detail.component.html',
  styleUrls: ['./facility-detail.component.css']
})
export class FacilityDetailComponent implements OnInit {
  facility: Facility;
  types: RentType[] = []
  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private rentType: RenTypeService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
  }

  ngOnInit(): void {
    this.types = this.rentType.findALl();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.facilityService.findByIdRest(+paramMap.get('id')).subscribe(data => {
        this.facility = data;
        console.log(this.facility);
      });
    });
  }

}
