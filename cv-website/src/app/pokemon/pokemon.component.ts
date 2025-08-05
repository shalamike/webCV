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
  evolvesToList: { name: string; url: string }[] = [];
  evolvesFromName: string = '';
  evolvesFromUrl: string = '';

  constructor(
    private cdr: ChangeDetectorRef,
    private pokemonService: PokemonService
  ) { }

  fetchPokemon(): void {
    if (!this.searchName) {
      this.errorMessage = 'Please enter a Pokémon name.';
      this.pokemonData = null;
      return;
    }
    this.getPokemonData(this.searchName.toLowerCase());
  }

  fetchPokemonEvolution(name: string): void {
    if (!name) {
      console.warn('No evolution name provided.');
      return;
    }

    // console.log('Fetching evolution:', name);
    this.getPokemonData(name);
  }


  fetchPokemonEvolvesFrom(): void {
    this.fetchPokemonEvolution(this.evolvesFromName);
  }

  private getPokemonData(name: string): void {
    // clearing evolution data between searches
    this.evolvesFromName = '';
    this.evolvesFromUrl = '';
    this.evolvesToList = [];

    this.pokemonService.getPokemonByName(name).subscribe({
      next: (data) => {
        this.pokemonData = data;
        this.errorMessage = '';
        this.fetchAbilitiesDescriptions(this.pokemonData.abilities);
        this.getEvolutionInfo(
          this.pokemonData.species.name,
          this.pokemonData.species.url
        );
      },
      error: () => {
        this.errorMessage = 'Pokémon not found!';
        this.pokemonData = null;
      },
    });
  }

  // private getEvolutionInfo(name: string, url: string) {
  //   this.pokemonService.getPokemonDetails(url).subscribe(
  //     {
  //       next:(species) => {
  //         // console.log(species.evolution_chain.url);
  //         this.pokemonService.getPokemonDetails(species.evolution_chain.url).subscribe(
  //          {
  //            next:(evolutions: any) => {
  //             console.log(evolutions.chain.species.name) // starter pokemon name
  //             console.log(evolutions.chain.species.url) // starter pokeomon url
  //             console.log(evolutions.chain.evolves_to[0].species.name);//first evolution name
  //             console.log(evolutions.chain.evolves_to[0].species.url); // first evolution url
  //             console.log(evolutions.chain.evolves_to[0].evolves_to[0].species.name);//final evolution name
  //             console.log(evolutions.chain.evolves_to[0].evolves_to[0].species.url); // final evolution url
  //            }
  //          }
  //         )
  //       }
  //     }
  //   )
  // }

  private getEvolutionInfo(name: string, url: string) {
    this.pokemonService.getPokemonDetails(url).subscribe({
      next: (speciesData) => {
        const evolutionChainUrl = speciesData.evolution_chain.url;

        this.pokemonService.getPokemonDetails(evolutionChainUrl).subscribe({
          next: (evolutionData: any) => {
            const chain = evolutionData.chain;
            const currentName = name.toLowerCase();

            // Recursive search for current Pokémon node
            const findCurrentPokemon = (node: any, prev: any = null): any => {
              if (node.species.name === currentName) {
                return { current: node, previous: prev };
              }
              for (const evo of node.evolves_to) {
                const result = findCurrentPokemon(evo, node);
                if (result) return result;
              }
              return null;
            };

            const result = findCurrentPokemon(chain);

            if (result) {
              const { current, previous } = result;

              if (previous) {
                this.evolvesFromName = previous.species.name;
                this.evolvesFromUrl = previous.species.url;
              }

              if (current.evolves_to && current.evolves_to.length > 0) {
                this.evolvesToList = current.evolves_to.map((evo: any) => ({
                  name: evo.species.name,
                  url: evo.species.url,
                }));
              }
            }

            this.cdr.detectChanges();
          },
          error: () => console.error('Failed to fetch evolution chain'),
        });
      },
      error: () => console.error('Failed to fetch species data'),
    });
  }


  private fetchAbilitiesDescriptions(abilities: any[]): void {
    abilities.forEach((ability: any) => {
      this.getAbilityDescription(ability.ability.name, ability.ability.url);
    });
  }

  private getAbilityDescription(name: string, url: string): void {
    this.pokemonService.getPokemonDetails(url).subscribe({
      next: (abilityData) => {
        const englishEffect = this.extractEnglishEffect(abilityData);
        this.abilityDescriptions[name] =
          englishEffect || 'Description not available.';
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
