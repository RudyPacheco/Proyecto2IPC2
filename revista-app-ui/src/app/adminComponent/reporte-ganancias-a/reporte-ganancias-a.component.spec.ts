import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciasAComponent } from './reporte-ganancias-a.component';

describe('ReporteGananciasAComponent', () => {
  let component: ReporteGananciasAComponent;
  let fixture: ComponentFixture<ReporteGananciasAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciasAComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciasAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
