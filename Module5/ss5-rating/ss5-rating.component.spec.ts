import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Ss5RatingComponent } from './ss5-rating.component';

describe('Ss5RatingComponent', () => {
  let component: Ss5RatingComponent;
  let fixture: ComponentFixture<Ss5RatingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Ss5RatingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Ss5RatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
