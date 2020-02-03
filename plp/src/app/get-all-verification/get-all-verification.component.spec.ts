import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllVerificationComponent } from './get-all-verification.component';

describe('GetAllVerificationComponent', () => {
  let component: GetAllVerificationComponent;
  let fixture: ComponentFixture<GetAllVerificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllVerificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllVerificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
