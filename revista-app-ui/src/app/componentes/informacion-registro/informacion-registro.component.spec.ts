import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformacionRegistroComponent } from './informacion-registro.component';

describe('InformacionRegistroComponent', () => {
  let component: InformacionRegistroComponent;
  let fixture: ComponentFixture<InformacionRegistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InformacionRegistroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InformacionRegistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
