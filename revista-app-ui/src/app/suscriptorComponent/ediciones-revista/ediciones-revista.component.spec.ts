import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicionesRevistaComponent } from './ediciones-revista.component';

describe('EdicionesRevistaComponent', () => {
  let component: EdicionesRevistaComponent;
  let fixture: ComponentFixture<EdicionesRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdicionesRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdicionesRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
