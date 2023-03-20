import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ss3ColorpickerComponent } from './ss3-colorpicker.component';

describe('Ss3ColorpickerComponent', () => {
  let component: Ss3ColorpickerComponent;
  let fixture: ComponentFixture<Ss3ColorpickerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ss3ColorpickerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ss3ColorpickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
