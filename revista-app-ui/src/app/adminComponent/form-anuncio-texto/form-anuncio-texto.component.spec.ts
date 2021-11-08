import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAnuncioTextoComponent } from './form-anuncio-texto.component';

describe('FormAnuncioTextoComponent', () => {
  let component: FormAnuncioTextoComponent;
  let fixture: ComponentFixture<FormAnuncioTextoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAnuncioTextoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAnuncioTextoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
