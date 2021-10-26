import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEditperfilComponent } from './view-editperfil.component';

describe('ViewEditperfilComponent', () => {
  let component: ViewEditperfilComponent;
  let fixture: ComponentFixture<ViewEditperfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEditperfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewEditperfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
