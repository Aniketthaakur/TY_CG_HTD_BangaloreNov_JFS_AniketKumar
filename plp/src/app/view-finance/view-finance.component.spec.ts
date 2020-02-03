import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewFinanceComponent } from './view-finance.component';

describe('ViewFinanceComponent', () => {
  let component: ViewFinanceComponent;
  let fixture: ComponentFixture<ViewFinanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewFinanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewFinanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
