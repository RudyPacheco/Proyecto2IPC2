import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallesRevistaComponent } from './detalles-revista.component';

describe('DetallesRevistaComponent', () => {
  let component: DetallesRevistaComponent;
  let fixture: ComponentFixture<DetallesRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetallesRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallesRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
