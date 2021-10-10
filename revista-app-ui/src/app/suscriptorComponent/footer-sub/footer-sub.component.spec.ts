import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterSubComponent } from './footer-sub.component';

describe('FooterSubComponent', () => {
  let component: FooterSubComponent;
  let fixture: ComponentFixture<FooterSubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FooterSubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
