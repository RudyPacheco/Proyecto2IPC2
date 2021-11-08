import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAnuncioImagenComponent } from './form-anuncio-imagen.component';

describe('FormAnuncioImagenComponent', () => {
  let component: FormAnuncioImagenComponent;
  let fixture: ComponentFixture<FormAnuncioImagenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAnuncioImagenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAnuncioImagenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
