import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteSuscripcionComponent } from './reporte-suscripcion.component';

describe('ReporteSuscripcionComponent', () => {
  let component: ReporteSuscripcionComponent;
  let fixture: ComponentFixture<ReporteSuscripcionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteSuscripcionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteSuscripcionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
