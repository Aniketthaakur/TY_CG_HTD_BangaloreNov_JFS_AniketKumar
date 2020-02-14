import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewHaulierComponent } from './view-haulier.component';

describe('ViewHaulierComponent', () => {
  let component: ViewHaulierComponent;
  let fixture: ComponentFixture<ViewHaulierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewHaulierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewHaulierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
