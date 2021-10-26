import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEditperfileComponent } from './form-editperfile.component';

describe('FormEditperfileComponent', () => {
  let component: FormEditperfileComponent;
  let fixture: ComponentFixture<FormEditperfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormEditperfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormEditperfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
