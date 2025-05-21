import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  isCollapsed = true; // Tracks whether the table is collapsed, setting the inital state to collapsed

   // Toggles the collapsed state
   toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }

}
