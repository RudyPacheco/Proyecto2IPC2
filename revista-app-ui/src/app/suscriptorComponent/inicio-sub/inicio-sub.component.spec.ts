import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioSubComponent } from './inicio-sub.component';

describe('InicioSubComponent', () => {
  let component: InicioSubComponent;
  let fixture: ComponentFixture<InicioSubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioSubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
