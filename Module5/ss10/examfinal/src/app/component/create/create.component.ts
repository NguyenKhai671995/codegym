import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {LohangService} from "../../service/lohang.service";
import {SanphamService} from "../../service/sanpham.service";
import {LoHang} from "../../model/LoHang";
import {SanPham} from "../../model/SanPham";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  formUpdate: FormGroup;
  listLoHang : LoHang[] = [];
  listSanPham: SanPham[]= [];
  lohangs : LoHang = {};
  constructor(private formBuilder: FormBuilder,
              private route : Router,
              private activatedRoute : ActivatedRoute,
              private lohangService: LohangService,
              private sanphamService: SanphamService) { }

  ngOnInit(): void {
    this.lohangService.findAll('').subscribe(x=>{
        this.listLoHang= x;
    });
    this.sanphamService.findAll().subscribe(x=>{
      this.listSanPham = x;
    })
    this.buildForm();
  }

  buildForm() {
    this.formUpdate = this.formBuilder.group(
      {
        id: [this.lohangs.id],
        malohang: [this.lohangs.malohang,[Validators.required,Validators.pattern("^LH-\\d{4}$")]],
        sanpham: [this.lohangs.sanpham == undefined ? '' : this.lohangs.sanpham],
        soluong: [this.lohangs.soluong,[Validators.required,Validators.min(0)]],
        ngaynhap: [this.lohangs.ngaynhap ,[Validators.required]],
        ngaysanxuat: [this.lohangs.ngaysanxuat ,[Validators.required]],
        ngayhet: [this.lohangs.ngayhet,[Validators.required]],
      }
    )
  }
  saveData() {
    this.lohangService.save(this.formUpdate.value).subscribe(value => {
      this.route.navigateByUrl("").then(data => {
        this.formUpdate.reset();
        this.lohangs = {};
      })
    });
  }
}
