import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciaComponent } from './reporte-ganancia.component';

describe('ReporteGananciaComponent', () => {
  let component: ReporteGananciaComponent;
  let fixture: ComponentFixture<ReporteGananciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
