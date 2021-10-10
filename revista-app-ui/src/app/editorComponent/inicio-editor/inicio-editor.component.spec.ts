import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioEditorComponent } from './inicio-editor.component';

describe('InicioEditorComponent', () => {
  let component: InicioEditorComponent;
  let fixture: ComponentFixture<InicioEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
