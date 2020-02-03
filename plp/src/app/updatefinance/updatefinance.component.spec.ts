import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatefinanceComponent } from './updatefinance.component';

describe('UpdatefinanceComponent', () => {
  let component: UpdatefinanceComponent;
  let fixture: ComponentFixture<UpdatefinanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatefinanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatefinanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
