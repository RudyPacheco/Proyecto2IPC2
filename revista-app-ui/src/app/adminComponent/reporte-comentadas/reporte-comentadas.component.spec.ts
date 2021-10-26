import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteComentadasComponent } from './reporte-comentadas.component';

describe('ReporteComentadasComponent', () => {
  let component: ReporteComentadasComponent;
  let fixture: ComponentFixture<ReporteComentadasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteComentadasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteComentadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
