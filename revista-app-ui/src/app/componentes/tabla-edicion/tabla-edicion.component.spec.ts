import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaEdicionComponent } from './tabla-edicion.component';

describe('TablaEdicionComponent', () => {
  let component: TablaEdicionComponent;
  let fixture: ComponentFixture<TablaEdicionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablaEdicionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
