import { TestBed } from '@angular/core/testing';

import { WorldPopulationsServiceService } from './world-populations-service.service';

describe('WorldPopulationsServiceService', () => {
  let service: WorldPopulationsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorldPopulationsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
