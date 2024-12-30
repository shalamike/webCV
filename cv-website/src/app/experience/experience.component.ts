import { Component } from '@angular/core';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent {

  isCollapsed = true; // Tracks whether the table is collapsed, setting the inital state to collapsed

  // Toggles the collapsed state
  toggleCollapse() {
   this.isCollapsed = !this.isCollapsed;
 }
}
