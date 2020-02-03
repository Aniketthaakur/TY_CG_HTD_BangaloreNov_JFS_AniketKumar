import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllStatusComponent } from './get-all-status.component';

describe('GetAllStatusComponent', () => {
  let component: GetAllStatusComponent;
  let fixture: ComponentFixture<GetAllStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
