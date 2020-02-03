import { TestBed } from '@angular/core/testing';

import { GetAllStatusService } from './get-all-status.service';

describe('GetAllStatusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetAllStatusService = TestBed.get(GetAllStatusService);
    expect(service).toBeTruthy();
  });
});
