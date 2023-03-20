import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ss6RegisterComponent } from './ss6-register.component';

describe('Ss6RegisterComponent', () => {
  let component: Ss6RegisterComponent;
  let fixture: ComponentFixture<Ss6RegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ss6RegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ss6RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
