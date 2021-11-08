import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnuncioViewComponent } from './anuncio-view.component';

describe('AnuncioViewComponent', () => {
  let component: AnuncioViewComponent;
  let fixture: ComponentFixture<AnuncioViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnuncioViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnuncioViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
