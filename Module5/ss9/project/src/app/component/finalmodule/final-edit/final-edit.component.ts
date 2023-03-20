import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../../model/product/Product";
import {Category} from "../../../model/product/Category";
import {Sotietkiem} from "../../../model/final/Sotietkiem";
import {SotietkiemService} from "../../../service/finalservice/sotietkiem.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Khachhang} from "../../../model/final/Khachhang";
import {KhachhangService} from "../../../service/finalservice/khachhang.service";

@Component({
  selector: 'app-final-edit',
  templateUrl: './final-edit.component.html',
  styleUrls: ['./final-edit.component.css']
})
export class FinalEditComponent implements OnInit {
  productFormEdit: FormGroup;
  sotienguiSelect: Sotietkiem = {};
  khachhangSelect: Khachhang = {};
  message: boolean = false;

  constructor(private sotietkiemService: SotietkiemService,
              private khachhangService: KhachhangService,
              private route: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.buildForm();
// r oi` anh
    this.activatedRoute.paramMap.subscribe(data => {
      const id = +(data.get('id'));
      this.sotietkiemService.findById(id).subscribe(value => {
        this.sotienguiSelect = value;
        this.khachhangService.findById(value.cusId).subscribe(data => {
          this.khachhangSelect = data;
          console.log(data)
          this.buildForm();

        })
      })
    })
  }

  buildForm() {
    this.productFormEdit = new FormGroup({
      id: new FormControl(this.sotienguiSelect.id),
      // cusId : new FormControl(this.khachhangService.findById(this.khachhangSelect.id)),
      cusId: new FormControl(this.khachhangSelect.id),
      name: new FormControl(this.khachhangSelect.name),
      ngaymoso: new FormControl(this.sotienguiSelect.ngaymoso),
      ngaygui: new FormControl(this.sotienguiSelect.ngaygui),
      kyhan: new FormControl(this.sotienguiSelect.kyhan),
      sotiengui: new FormControl(this.sotienguiSelect.sotiengui),
      laixuat: new FormControl(this.sotienguiSelect.laixuat),
      uudai: new FormControl(this.sotienguiSelect.uudai),

    })
  }

  getSoTietKiemFormEdit(): Sotietkiem {
    return {
      id: this.productFormEdit.value.id,
      cusId: this.productFormEdit.value.cusId,
      ngaymoso: this.productFormEdit.value.ngaymoso,
      ngaygui: this.productFormEdit.value.ngaygui,
      kyhan: this.productFormEdit.value.kyhan,
      sotiengui: this.productFormEdit.value.sotiengui,
      laixuat: this.productFormEdit.value.laixuat,
      uudai: this.productFormEdit.value.uudai,
    }
  }

  getKhachHangFormEdit(): Khachhang {
    return {
      id: this.productFormEdit.value.cusId,
      name: this.productFormEdit.value.name
    }
  }

  saveEdit() {
    this.sotietkiemService.updateById(this.getSoTietKiemFormEdit()).subscribe(value => {
      this.khachhangService.updateById(this.getKhachHangFormEdit()).subscribe(value => {
        this.message = true;
      })
    });
  }


  removeMessage() {
    this.message = false;
    this.route.navigateByUrl('').then(result => {
      this.productFormEdit.reset();
    })
  }
}
