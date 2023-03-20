import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RentType} from "../../../model/facility/RenType";
import {FacilityType} from "../../../model/facility/FacilityType";
import {Facility} from "../../../model/facility/Facility";
import {ActivatedRoute, Router} from "@angular/router";
import {RenTypeService} from "../../../service/facility/ren-type.service";
import {FacilityTypeService} from "../../../service/facility/facility-type.service";
import {FacilityService} from "../../../service/facility/facility.service";

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-update.component.html',
  styleUrls: ['./facility-update.component.css']
})
export class FacilityUpdateComponent implements OnInit {
  formCreate: FormGroup;
  facilityEdit: Facility = {};
  rents: RentType[] = [];
  facilityTypes: FacilityType[] = [];

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private facilityService: FacilityService,
              private rentTypeService: RenTypeService,
              private facilityTypeService: FacilityTypeService) {
  }

  ngOnInit(): void {
    this.buildForm();
    this.rents = this.rentTypeService.findALl();
    this.facilityTypes = this.facilityTypeService.findALl();
    if (this.router.url.includes("create")) return;
    console.log(this.formCreate.value)

    this.activatedRoute.paramMap.subscribe(value => {
      let id = +value.get("id");
      this.facilityService.findById(id).subscribe(data => {
        this.facilityEdit = data;
        this.buildForm();
      })
    })
  }


  buildForm() {
    this.formCreate = this.formBuilder.group({
      id: [this.facilityEdit.id],
      nameService: [this.facilityEdit.nameService, [Validators.required]],
      area: [this.facilityEdit.area, [Validators.min(1)]],
      cost: [this.facilityEdit.cost],
      maxPeople: [this.facilityEdit.maxPeople],
      standardRoom: [this.facilityEdit.standardRoom],
      descriptionOtherConvenience: [this.facilityEdit.descriptionOtherConvenience],
      areaPool: [this.facilityEdit.area],
      numberOfFloors: [this.facilityEdit.numberOfFloors],
      freeService: [this.facilityEdit.freeService],
      rentType: [this.facilityEdit.rentType == undefined ? '' : this.facilityEdit.rentType],
      facilityType: [this.facilityEdit.facilityType == undefined ? '' : this.facilityEdit.facilityType]
    })
  }

  saveData() {
    this.facilityService.save(this.formCreate.value).subscribe(value => {
      this.router.navigateByUrl("/facility/facility-list").then(data => {
        this.formCreate.reset();
        this.facilityEdit = {};
      })
    });
  }
}
