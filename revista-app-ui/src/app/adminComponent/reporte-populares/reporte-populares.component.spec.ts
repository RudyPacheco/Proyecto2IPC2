import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportePopularesComponent } from './reporte-populares.component';

describe('ReportePopularesComponent', () => {
  let component: ReportePopularesComponent;
  let fixture: ComponentFixture<ReportePopularesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportePopularesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportePopularesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
