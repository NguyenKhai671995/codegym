import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ss3CalculatorComponent } from './ss3-calculator.component';

describe('Ss3CalculatorComponent', () => {
  let component: Ss3CalculatorComponent;
  let fixture: ComponentFixture<Ss3CalculatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ss3CalculatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ss3CalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
