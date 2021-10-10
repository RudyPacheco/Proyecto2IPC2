import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRevistaComponent } from './form-revista.component';

describe('FormRevistaComponent', () => {
  let component: FormRevistaComponent;
  let fixture: ComponentFixture<FormRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
