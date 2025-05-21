import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HobbiesInterestsProjectsComponent } from './hobbies-interests-projects.component';

describe('HobbiesInterestsProjectsComponent', () => {
  let component: HobbiesInterestsProjectsComponent;
  let fixture: ComponentFixture<HobbiesInterestsProjectsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HobbiesInterestsProjectsComponent]
    });
    fixture = TestBed.createComponent(HobbiesInterestsProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
