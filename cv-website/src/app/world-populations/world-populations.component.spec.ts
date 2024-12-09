import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorldPopulationsComponent } from './world-populations.component';

describe('WorldPopulationsComponent', () => {
  let component: WorldPopulationsComponent;
  let fixture: ComponentFixture<WorldPopulationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WorldPopulationsComponent]
    });
    fixture = TestBed.createComponent(WorldPopulationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
