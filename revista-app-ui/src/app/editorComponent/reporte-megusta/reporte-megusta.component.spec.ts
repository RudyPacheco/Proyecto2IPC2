import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteMegustaComponent } from './reporte-megusta.component';

describe('ReporteMegustaComponent', () => {
  let component: ReporteMegustaComponent;
  let fixture: ComponentFixture<ReporteMegustaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteMegustaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteMegustaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
