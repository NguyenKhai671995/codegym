import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Final2ListComponent } from './final2-list.component';

describe('Final2ListComponent', () => {
  let component: Final2ListComponent;
  let fixture: ComponentFixture<Final2ListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Final2ListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Final2ListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
