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
  isCollapsed: boolean = true;
  searchPopulation: number = 0;
  countryData: any = null;
  errorMessage: string = '';

  constructor(private worldPopulationsService: WorldPopulationsServiceService) {}

  // fetchCitiesByCountry(country: string): void {
  //   this.worldPopulationsService.getCitiesByCountry(country).subscribe({
  //     next: (data) => {
  //       // console.log(data);
  //       this.countryData = data;
  //     },
  //     error: () => {
  //       // console.log('Error fetching cities');
  //       this.errorMessage = 'Country not found!';
  //       this.countryData = null;
  //       return;
  //     }
  //   });
  // }

  // fetchCitiesWithPopulationAbove(population: number): void {
  //   this.worldPopulationsService.getCitiesWithPopulationAbove(population).subscribe({
  //     next: (data) => {
  //       console.log(data);
  //     },
  //     error: () => {
  //       console.log('Error fetching cities');
  //     }
  //   });
  // }

  // fetchCitiesInCountryWithPopulationAbove(country: string, minPopulation: number): void {
  //   this.worldPopulationsService.getCitiesinCountryWithPopulationAbove(country, minPopulation).subscribe({
  //     next: (data) => {
  //       console.log(data);
  //     },
  //     error: () => {
  //       console.log('Error fetching cities');
  //     }
  //   });
  // }

  fetchCountryByName(country: string): void {
    this.worldPopulationsService.getCountryByName(country).subscribe({
      next: (data) => {
        console.log(data);
        this.countryData = data;
      },
      error: () => {
        console.log('Error fetching country');
        this.errorMessage = 'Country not found!';
        this.countryData = null;
        return;
      }
    });
  }


  toggleCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
  }
}
