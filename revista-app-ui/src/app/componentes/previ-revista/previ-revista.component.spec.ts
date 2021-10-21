import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreviRevistaComponent } from './previ-revista.component';

describe('PreviRevistaComponent', () => {
  let component: PreviRevistaComponent;
  let fixture: ComponentFixture<PreviRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreviRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreviRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
