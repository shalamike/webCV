import { Component, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-hobbies-interests-projects',
  templateUrl: './hobbies-interests-projects.component.html',
  styleUrls: ['./hobbies-interests-projects.component.css']
})
export class HobbiesInterestsProjectsComponent {
  
  isCollapsed = true; // Tracks whether the table is collapsed, setting the inital state to collapsed
  isExpanded: string | null = null; // Tracks the expanded component
  constructor(private cdr: ChangeDetectorRef, private router: Router) {}

   // Toggles the collapsed state
   toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }

  toggleExpand(component: string) {
    if (this.isExpanded === component) {
      // Collapsing the same component
      this.isExpanded = null;
    } else {
      // Expand the new component
      this.isExpanded = component;
    }
  }

  navigateToPokemon() {
    this.router.navigate(['/pokemon']);
    console.log('Navigating to Pokémon page');
  }

  // Force reflow if collapsing affects container layout
  forceReflow() {
    if (!this.isExpanded) {
      setTimeout(() => this.cdr.detectChanges(), 0);
    }
  }
  
}
