import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetLoanProgramComponent } from './get-loan-program.component';

describe('GetLoanProgramComponent', () => {
  let component: GetLoanProgramComponent;
  let fixture: ComponentFixture<GetLoanProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetLoanProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetLoanProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
