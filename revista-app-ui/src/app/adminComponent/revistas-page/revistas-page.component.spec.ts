import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevistasPageComponent } from './revistas-page.component';

describe('RevistasPageComponent', () => {
  let component: RevistasPageComponent;
  let fixture: ComponentFixture<RevistasPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RevistasPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RevistasPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
