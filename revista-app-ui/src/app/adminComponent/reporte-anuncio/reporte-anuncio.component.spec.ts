import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteAnuncioComponent } from './reporte-anuncio.component';

describe('ReporteAnuncioComponent', () => {
  let component: ReporteAnuncioComponent;
  let fixture: ComponentFixture<ReporteAnuncioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteAnuncioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteAnuncioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
