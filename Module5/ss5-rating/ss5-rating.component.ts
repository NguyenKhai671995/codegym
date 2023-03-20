import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-ss5-rating',
  templateUrl: './ss5-rating.component.html',
  styleUrls: ['./ss5-rating.component.css']
})
export class Ss5RatingComponent implements OnInit {
  @Input()
  value: number;

  @Output()
  changeValueInInput : EventEmitter<number> = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  changeValue(value: number ){
    console.log(value)
    if (value >10){
      return;
    }
    this.value = value;

    this.changeValueInInput.emit(value);
  }
}
