import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/product/Category";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {SotietkiemService} from "../../../service/finalservice/sotietkiem.service";
import {ActivatedRoute, Router} from "@angular/router";
import {KhachhangService} from "../../../service/finalservice/khachhang.service";
import {Khachhang} from "../../../model/final/Khachhang";
import {Sotietkiem} from "../../../model/final/Sotietkiem";

@Component({
  selector: 'app-final-create',
  templateUrl: './final-create.component.html',
  styleUrls: ['./final-create.component.css']
})
export class FinalCreateComponent implements OnInit {
  message: boolean = false;
  formUpdate: FormGroup;

  constructor(private sotietkiemService: SotietkiemService,
              private khachhangService: KhachhangService,
              private activitedRouter: ActivatedRoute,
              private route: Router) {
  }

  ngOnInit(): void {
    this.buildForm();
  }
  buildForm() {

    this.formUpdate = new FormGroup(
      {
        id: new FormControl(),
        cusId: new FormControl(),
        name: new FormControl(''),
        ngaymoso: new FormControl('', [Validators.required]),
        ngaygui: new FormControl('', [Validators.required]),
        kyhan: new FormControl('', [Validators.required]),
        sotiengui: new FormControl('', [Validators.required]),
        laixuat: new FormControl('', [Validators.required]),
        uudai: new FormControl('', [Validators.required])
      }
    )
  }

  saveCreate() {
    this.khachhangService.save(this.getKhachHangFormCreate()).subscribe(value => {
      this.sotietkiemService.save(this.getSoTietKiemFormCreate(value)).subscribe(data => {
        this.message = true;
      })
    })

  }

  removeMessage() {
    this.message = false;
    this.route.navigateByUrl('').then(result => {
      this.formUpdate.reset();
    })
  }

  getKhachHangFormCreate(): Khachhang {
    return {
      id: this.formUpdate.value.cusId,
      name: this.formUpdate.value.name
    }
  }
  getSoTietKiemFormCreate(value: Khachhang) : Sotietkiem{
    return {
      id: this.formUpdate.value.id,
      cusId: value.id,
      ngaymoso: this.formUpdate.value.ngaymoso,
      ngaygui: this.formUpdate.value.ngaygui,
      kyhan: this.formUpdate.value.kyhan,
      sotiengui: this.formUpdate.value.sotiengui,
      laixuat: this.formUpdate.value.laixuat,
      uudai: this.formUpdate.value.uudai,
    }
  }


}
