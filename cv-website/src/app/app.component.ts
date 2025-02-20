import { Component, ViewChildren, QueryList } from '@angular/core';
import { MatExpansionPanel } from '@angular/material/expansion';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cv-website';
// Get a QueryList of all MatExpansionPanel components
@ViewChildren(MatExpansionPanel) panels!: QueryList<MatExpansionPanel>;

expandAll(): void {
  this.panels.forEach(panel => panel.open());
}

collapseAll(): void {
  this.panels.forEach(panel => panel.close());
}
}


