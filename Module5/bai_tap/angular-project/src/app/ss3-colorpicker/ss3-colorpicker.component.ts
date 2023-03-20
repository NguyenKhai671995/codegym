import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ss3-colorpicker',
  templateUrl: './ss3-colorpicker.component.html',
  styleUrls: ['./ss3-colorpicker.component.css']
})
export class Ss3ColorpickerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  public backgroundNew = '';
  public colorNew = '';
  changeColor(value: string) {
    switch (value) {
      case "primary": {
        this.backgroundNew = "blue";
        this.colorNew = "white";
        break;
      }
      case "Secondary": {
        this.backgroundNew = "grey";
        this.colorNew = "blue";
        break;
      }
      case "Success": {
        this.backgroundNew = "green";
        this.colorNew = "black";
        break;
      }
      case "Danger":{
        this.backgroundNew = "red";
        this.colorNew = "yellow";
        break;
      }
      case "Warning":{
        this.backgroundNew = "yellow";
        this.colorNew = "cyan";
        break;
      }
      case "info":{
        this.backgroundNew = "cyan";
        this.colorNew = "green";
        break;
      }
      case "Light":{
        this.backgroundNew = "white";
        this.colorNew = "orange";
        break;
      }
      case "Dark":{
        this.backgroundNew = "black";
        this.colorNew = "radio";
        break;
      }
    }
  }
}
