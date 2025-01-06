import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cv-website';
  isExpanded: string | null = null;

  toggleExpand(component: string) {
    // Toggle between expanded and collapsed state
    this.isExpanded = this.isExpanded === component ? null : component;

  }
}


