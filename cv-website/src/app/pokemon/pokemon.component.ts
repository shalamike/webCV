import { ChangeDetectorRef, Component } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css'],
})
export class PokemonComponent {
  searchName: string = '';
  pokemonData: any = null;
  errorMessage: string = '';
  abilityDescriptions: { [key: string]: string } = {};
  isCollapsed = true;

  constructor(private cdr: ChangeDetectorRef, private pokemonService: PokemonService) {}

  fetchPokemon(): void {
    if (!this.searchName) {
      this.errorMessage = 'Please enter a Pokémon name.';
      this.pokemonData = null;
      return;
    }

    this.getPokemonData(this.searchName.toLowerCase());
  }

  private getPokemonData(name: string): void {
    this.pokemonService.getPokemonByName(name).subscribe({
      next: (data) => {
        this.pokemonData = data;
        this.errorMessage = '';
        this.fetchAbilitiesDescriptions(this.pokemonData.abilities);
      },
      error: () => {
        this.errorMessage = 'Pokémon not found!';
        this.pokemonData = null;
      },
    });
  }

  private fetchAbilitiesDescriptions(abilities: any[]): void {
    abilities.forEach((ability: any) => {
      this.getAbilityDescription(ability.ability.name, ability.ability.url);
    });
  }

  private getAbilityDescription(name: string, url: string): void {
    this.pokemonService.getPokemonAbilitiesDetails(url).subscribe({
      next: (abilityData) => {
        const englishEffect = this.extractEnglishEffect(abilityData);
        this.abilityDescriptions[name] = englishEffect || 'Description not available.';
      },
      error: () => {
        this.abilityDescriptions[name] = 'Description not available.';
      },
    });
  }

  private extractEnglishEffect(abilityData: any): string | null {
    const effectEntry = abilityData.effect_entries.find(
      (entry: any) => entry.language.name === 'en'
    );
    return effectEntry?.effect || null;
  }

  toggleCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
    if (this.isCollapsed) {
      // Clear data when collapsed
      this.pokemonData = null;
      this.errorMessage = '';
      this.abilityDescriptions = {};
    }
    this.cdr.detectChanges(); // Trigger UI update
  }
}
