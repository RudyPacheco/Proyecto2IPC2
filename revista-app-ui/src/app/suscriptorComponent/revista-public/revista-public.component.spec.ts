import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevistaPublicComponent } from './revista-public.component';

describe('RevistaPublicComponent', () => {
  let component: RevistaPublicComponent;
  let fixture: ComponentFixture<RevistaPublicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RevistaPublicComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RevistaPublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
