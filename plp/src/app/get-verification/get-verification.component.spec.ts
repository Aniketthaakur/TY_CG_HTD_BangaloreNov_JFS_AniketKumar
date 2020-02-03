import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetVerificationComponent } from './get-verification.component';

describe('GetVerificationComponent', () => {
  let component: GetVerificationComponent;
  let fixture: ComponentFixture<GetVerificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetVerificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetVerificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
