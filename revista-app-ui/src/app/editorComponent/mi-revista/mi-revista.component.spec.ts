import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiRevistaComponent } from './mi-revista.component';

describe('MiRevistaComponent', () => {
  let component: MiRevistaComponent;
  let fixture: ComponentFixture<MiRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
