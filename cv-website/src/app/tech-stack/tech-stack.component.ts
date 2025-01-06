import { Component } from '@angular/core';

@Component({
  selector: 'app-tech-stack',
  templateUrl: './tech-stack.component.html',
  styleUrls: ['./tech-stack.component.css']
})
export class TechStackComponent {
  
  skills = [
      { technology: 'Programming Languages', componentWith: 'Java, Python, HTML, CSS, Javascript, Typescript', experiencedWith: 'C#, Kotlin' },
      { technology: 'IDE\'s', componentWith: 'IntelliJ, Ryder, Pycharm, Eclipse, VS Code', experiencedWith: 'Visual Studio, Android Studio'},
      { technology: 'Frameworks', componentWith: 'Spring Boot, Angular Typescript, Bootstrap', experiencedWith: 'React Js, Thymeleaf, NodeJs'},
      { technology: 'Database Management Technologies', componentWith: 'MySQL, SQL+', experiencedWith:'MongoDB'},
      { technology: 'Testing-tools', componentWith: 'Junit, Mockito', experiencedWith: 'sonar-cube, Selenium and Cucumber, Pytest'},
      { technology: 'Other', componentWith: 'Postman, Jira', experiencedWith: 'YAML, Flyway'}
  ];
  
  hoveredRow: number | null = null; // Tracks the currently hovered row index
  hoveredColumn: number | null = null; // Tracks the currently hovered column index
  
  isCollapsed = true; // Tracks whether the table is collapsed, setting the inital state to collapsed
  
     // Toggles the collapsed state
  toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }
  
    // Update hoveredRow and hoveredColumn on mouse events
  onMouseEnterCell(rowIndex: number, columnIndex: number) {
    this.hoveredRow = rowIndex;
    this.hoveredColumn = columnIndex;
    console.log('hoveredRow: ', this.hoveredRow);
    console.log('hoveredColumn: ', this.hoveredColumn);
  }
  
  //ensures that when the mouse is no longer hovering over a cell, it resets to null to make sure nothing is highlighted
  onMouseLeaveCell() {
    this.hoveredRow = null;
    this.hoveredColumn = null;
  }
  
}
  
