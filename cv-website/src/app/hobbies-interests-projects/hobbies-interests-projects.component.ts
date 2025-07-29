import { Component, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-hobbies-interests-projects',
  templateUrl: './hobbies-interests-projects.component.html',
  styleUrls: ['./hobbies-interests-projects.component.css']
})
export class HobbiesInterestsProjectsComponent {


  aboutMeParagraphs = [
    {text: 'Hello! I\'m Mike, a software developer with a passion for building clean and functional applications. I enjoy working across the full stack and learning new tools and technologies.', image: 'assets/myself1.jpg'},
    {text: 'I am an enthusiastic full-stack developer with solid experience in Java, Spring Boot, SQL, HTML, CSS, JavaScript, and TypeScript. Proficient in modern frontend frameworks like AngularJS and ReactJS, I can build scalable, user-friendly applications from backend to interface. I thrive in agile environments, collaborate effectively across disciplines, and continuously seek to learn, adapt, and deliver high-performance, maintainable solutions.', image: 'assets/myself2.jpg'}
  ]
  
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
