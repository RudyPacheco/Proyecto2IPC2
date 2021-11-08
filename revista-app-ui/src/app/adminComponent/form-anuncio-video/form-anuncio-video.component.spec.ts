import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAnuncioVideoComponent } from './form-anuncio-video.component';

describe('FormAnuncioVideoComponent', () => {
  let component: FormAnuncioVideoComponent;
  let fixture: ComponentFixture<FormAnuncioVideoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAnuncioVideoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAnuncioVideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
