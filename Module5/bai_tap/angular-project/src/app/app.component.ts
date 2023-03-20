import { Component } from '@angular/core';
import {isLineBreak} from 'codelyzer/angular/sourceMappingVisitor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-project';
 currentValue: number;

  getValueByChild($event: number) {
     this.currentValue = $event;

  }
}
