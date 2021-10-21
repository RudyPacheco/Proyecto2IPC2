import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicionRevistaComponent } from './edicion-revista.component';

describe('EdicionRevistaComponent', () => {
  let component: EdicionRevistaComponent;
  let fixture: ComponentFixture<EdicionRevistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdicionRevistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EdicionRevistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
