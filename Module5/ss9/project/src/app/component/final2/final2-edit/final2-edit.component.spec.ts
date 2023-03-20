import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Final2EditComponent } from './final2-edit.component';

describe('Final2EditComponent', () => {
  let component: Final2EditComponent;
  let fixture: ComponentFixture<Final2EditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Final2EditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Final2EditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
