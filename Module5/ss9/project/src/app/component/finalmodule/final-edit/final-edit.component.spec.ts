import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalEditComponent } from './final-edit.component';

describe('FinalEditComponent', () => {
  let component: FinalEditComponent;
  let fixture: ComponentFixture<FinalEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinalEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinalEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
