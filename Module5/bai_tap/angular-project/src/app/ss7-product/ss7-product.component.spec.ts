import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ss7ProductComponent } from './ss7-product.component';

describe('Ss7ProductComponent', () => {
  let component: Ss7ProductComponent;
  let fixture: ComponentFixture<Ss7ProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ss7ProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ss7ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
