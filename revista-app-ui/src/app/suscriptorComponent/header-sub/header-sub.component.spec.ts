import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderSubComponent } from './header-sub.component';

describe('HeaderSubComponent', () => {
  let component: HeaderSubComponent;
  let fixture: ComponentFixture<HeaderSubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderSubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderSubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
