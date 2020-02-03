import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVerifcationComponent } from './update-verifcation.component';

describe('UpdateVerifcationComponent', () => {
  let component: UpdateVerifcationComponent;
  let fixture: ComponentFixture<UpdateVerifcationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateVerifcationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateVerifcationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
