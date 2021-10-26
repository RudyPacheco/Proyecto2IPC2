import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEditperfilsubComponent } from './form-editperfilsub.component';

describe('FormEditperfilsubComponent', () => {
  let component: FormEditperfilsubComponent;
  let fixture: ComponentFixture<FormEditperfilsubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormEditperfilsubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormEditperfilsubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
