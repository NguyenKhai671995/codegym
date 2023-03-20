import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalCreateComponent } from './final-create.component';

describe('FinalCreateComponent', () => {
  let component: FinalCreateComponent;
  let fixture: ComponentFixture<FinalCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinalCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinalCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
