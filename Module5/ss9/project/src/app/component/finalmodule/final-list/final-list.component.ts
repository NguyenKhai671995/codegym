import {Component, OnInit} from '@angular/core';
import {SotietkiemService} from "../../../service/finalservice/sotietkiem.service";
import {Router} from "@angular/router";

import {Sotietkiem} from "../../../model/final/Sotietkiem";
import {Khachhang} from "../../../model/final/Khachhang";
import {KhachhangService} from "../../../service/finalservice/khachhang.service";

@Component({
  selector: 'app-final-list',
  templateUrl: './final-list.component.html',
  styleUrls: ['./final-list.component.css']
})
export class FinalListComponent implements OnInit {
  sotietkiems: Sotietkiem[] = [];
  khachhangs: Khachhang[] = [];
  config: any;
  khachhangSelect : Khachhang = {};
  sotietkiemSelect: Sotietkiem = {};

  message: boolean = false;

  constructor(private sotietkiemService: SotietkiemService,
              private route: Router,
              private khachhangService: KhachhangService) {
  }

  ngOnInit(): void {
    this.findAllSoTietKiem();

  }

  findAllSoTietKiem() {
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.sotietkiems.length
    }
    this.sotietkiemService.findAll().subscribe(value => {
      this.khachhangService.findAll().subscribe(data => {
        this.sotietkiems = value;
        this.khachhangs = data;
        console.log(this.khachhangs)

      })
      this.config = {
        itemsPerPage: 4,
        currentPage: 1,
        totalItems: this.sotietkiems.length
      }
    })
  }


  wantDeleteIt(sotietkiem: Sotietkiem) {
    this.sotietkiemSelect = sotietkiem;
  }

  deleteThis(id: number) {
    this.sotietkiemService.deleteById(id).subscribe(data => {
      this.sotietkiemSelect = {};
      document.getElementById("deleteModal").click();
      this.message = true;

      this.ngOnInit();
    })
  }
  removeMessage() {
    this.message = false
  }

  pageChanged(event: number) {
    this.config.currentPage = event;
  }
}
