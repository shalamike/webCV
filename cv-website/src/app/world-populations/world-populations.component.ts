import { Component } from '@angular/core';
import { WorldPopulationsServiceService } from '../services/world-populations-service.service';

@Component({
  selector: 'app-world-populations',
  templateUrl: './world-populations.component.html',
  styleUrls: ['./world-populations.component.css']
})
export class WorldPopulationsComponent {
  searchCountry: string = '';
  searchCity: string = '';
  searchLanguage: string = '';
  isCollapsed: boolean = false;

  constructor(private worldPopulationsService: WorldPopulationsServiceService) {}

  fetchCitiesByCountry(country: string): void {
    this.worldPopulationsService.getCitiesByCountry(country).subscribe({
      next: (data) => {
        console.log(data);
      },
      error: () => {
        console.log('Error fetching cities');
      }
    });
  }


  toggleCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
  }
}
