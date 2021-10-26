import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteComentarioComponent } from './reporte-comentario.component';

describe('ReporteComentarioComponent', () => {
  let component: ReporteComentarioComponent;
  let fixture: ComponentFixture<ReporteComentarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteComentarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteComentarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
