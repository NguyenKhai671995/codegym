import { Component, OnInit } from '@angular/core';
import {SinhVien} from "../../../model/final2/SinhVien";
import {GiaoVien} from "../../../model/final2/GiaoVien";
import {TenNhom} from "../../../model/final2/TenNhom";
import {StudentService} from "../../../service/final2Service/student.service";
import {GroupService} from "../../../service/final2Service/group.service";
import {TeacherService} from "../../../service/final2Service/teacher.service";
import {Router} from "@angular/router";
import {Product} from "../../../model/product/Product";

@Component({
  selector: 'app-final2-list',
  templateUrl: './final2-list.component.html',
  styleUrls: ['./final2-list.component.css']
})
export class Final2ListComponent implements OnInit {
  students : SinhVien[] = [];
  teachers : GiaoVien[]= [];
  groupes : TenNhom[] = [];
  config: any;
  message: boolean = false;
  studentSelect: SinhVien = {};
  constructor(private studentService: StudentService,
              private groupService : GroupService,
              private teacherService: TeacherService,
              private route : Router) { }

  ngOnInit(): void {
    this.findAllList();
  }

  findAllList(){
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.students.length
    };
    this.studentService.findAll().subscribe(value => {
      this.teachers = this.teacherService.findAll();
      this.groupes = this.groupService.findAll();
      this.students = value;
      this.config = {
        itemsPerPage: 4,
        currentPage: 1,
        totalItems: this.students.length
      };
    })
  }

  pageChanged(event: number) {
    this.config.currentPage = event;
  }

  wantDeleteIt(student: SinhVien) {
    this.studentSelect = student;
  }

  deleteThis(id: number) {
    this.studentService.deleteById(id).subscribe(value => {
      this.studentSelect = {};
      document.getElementById("deleteModal").click()
      this.message = true;
      this.ngOnInit();
    })
  }
  removeMessage() {
    this.message = false
  }
}
