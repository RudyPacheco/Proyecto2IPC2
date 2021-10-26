import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilSubComponent } from './perfil-sub.component';

describe('PerfilSubComponent', () => {
  let component: PerfilSubComponent;
  let fixture: ComponentFixture<PerfilSubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerfilSubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
