import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagConteinerComponent } from './tag-conteiner.component';

describe('TagConteinerComponent', () => {
  let component: TagConteinerComponent;
  let fixture: ComponentFixture<TagConteinerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TagConteinerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TagConteinerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
