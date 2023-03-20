import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-ss3-calculator',
  templateUrl: './ss3-calculator.component.html',
  styleUrls: ['./ss3-calculator.component.css']
})
export class Ss3CalculatorComponent implements OnInit {

  constructor(private route : Router) {
  }

  ngOnInit(): void {
  }

  result = '0';

  currvalue = '';


  writetoinput(value: string) {
    if (this.currvalue == '0') {
      this.currvalue = value;
    }
    if (this.currvalue != '0') {
      this.currvalue += value;
    }
    this.result = this.currvalue;
  }

  equals() {
    this.result = eval(this.result);
    this.currvalue = this.result;
  }

  delete() {
    this.currvalue = "";
    this.result = '0';
  }

  backone() {
    this.result = this.result.substr(0, this.result.length - 1);
    this.currvalue = this.result;
  }
}
