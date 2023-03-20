import {Component, OnInit} from '@angular/core';
import {LoHang} from "../../model/LoHang";
import {SanPham} from "../../model/SanPham";
import {LohangService} from "../../service/lohang.service";
import {SanphamService} from "../../service/sanpham.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  listLoHang: LoHang[] = [];
  listSanPham: SanPham[] = [];
  lohangDelete : LoHang = {}
  sanphamDelete : SanPham = {};
  config: any;
  formSearch: FormGroup;
  message: boolean = false;

  constructor(private lohangService: LohangService,
              private sanphamService: SanphamService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.loadPage('');
    this.removeMessage();
    this.formSearch = new FormGroup({
      sanpham: new FormControl("")
    });

  }

  loadPage( sanpham: string) {
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.listLoHang.length
    };
    this.lohangService.findAll( sanpham).subscribe(value => {
      this.sanphamService.findAll().subscribe(x => {
        this.listSanPham = x;
        this.listLoHang = value;
        this.config = {
          itemsPerPage: 4,
          currentPage: 1,
          totalItems: this.listLoHang.length
        }
      })
    });
  }

  pageChanged(event: number) {
    this.config.currentPage = event;
  }
  wantDeleteIt(itemDelete : LoHang) {
    this.lohangDelete = itemDelete;

  }

  deleteThis(id: number) {
    this.lohangService.deleteById(id).subscribe(data => {
      this.lohangDelete = {};
      document.getElementById("deleteModal").click();
      this.message = true;
      this.loadPage('');
    })
  }

  removeMessage() {
    this.message = false
  }

  searchByName(){
      this.loadPage(this.formSearch.value.sanpham);
  }
  resetPage() {
    this.formSearch.reset();
    this.ngOnInit();
  }
}
