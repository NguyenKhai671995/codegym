import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SinhVien} from "../../../model/final2/SinhVien";
import {TenNhom} from "../../../model/final2/TenNhom";
import {GiaoVien} from "../../../model/final2/GiaoVien";
import {StudentService} from "../../../service/final2Service/student.service";
import {TeacherService} from "../../../service/final2Service/teacher.service";
import {GroupService} from "../../../service/final2Service/group.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-final2-edit',
  templateUrl: './final2-edit.component.html',
  styleUrls: ['./final2-edit.component.css']
})
export class Final2EditComponent implements OnInit {
  formEdit : FormGroup;
  stundentSelect : SinhVien = {};
  groupes : TenNhom[] = [];
  techers : GiaoVien[]= [];
  message: boolean = false;

  constructor(private studentService : StudentService,
              private teacherService : TeacherService,
              private groupService: GroupService,
              private activatedRoute : ActivatedRoute,
              private route : Router) { }

  ngOnInit(): void {
    this.buildForm();
    this.groupes = this.groupService.findAll();
    this.techers = this.teacherService.findAll();
    this.activatedRoute.paramMap.subscribe(data => {
      const id = +(data.get('id'));
      this.studentService.findById(id).subscribe(value => {
        this.stundentSelect = value;
        this.buildForm();
      })
    })
  }


  buildForm(){
    this.formEdit = new FormGroup({
      id: new FormControl(this.stundentSelect.id),
      name: new FormControl(this.stundentSelect.name,[Validators.required,Validators.pattern("^[a-zA-Z0-9 ]+$")]),
      tennhom: new FormControl(this.stundentSelect.tennhom),
      tendetai: new FormControl(this.stundentSelect.tendetai),
      giaovien: new FormControl(this.stundentSelect.giaovien),
      email: new FormControl(this.stundentSelect.email,[Validators.required,Validators.email]),
      sodienthoai: new FormControl(this.stundentSelect.sodienthoai,[Validators.required,Validators.pattern("^(\\+84|0)\\d{9}$")]),
    })
  }

  saveEdit(){
    this.studentService.updateById(this.formEdit.value).subscribe(value => {
      this.message = true;
    })
  }

  removeMessage() {
    this.route.navigateByUrl("/final2/final2-list").then(result => {
      this.formEdit.reset();
      this.stundentSelect = {};
    })
  }
}
