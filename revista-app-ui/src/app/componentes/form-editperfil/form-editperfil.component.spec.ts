import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEditperfilComponent } from './form-editperfil.component';

describe('FormEditperfilComponent', () => {
  let component: FormEditperfilComponent;
  let fixture: ComponentFixture<FormEditperfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormEditperfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormEditperfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
