import { ChangeDetectorRef, Component } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';
import { Observable, map, startWith } from 'rxjs';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css'],
})
export class PokemonComponent {
  // searchName: string = '';
  pokemonData: any = null;
  errorMessage: string = '';
  abilityDescriptions: { [key: string]: string } = {};
  isCollapsed = true;
  evolvesToList: { name: string; url: string }[] = [];
  evolvesFromName: string = '';
  evolvesFromUrl: string = '';
  PokemonNamesList: string[] = [];
  searchControl = new FormControl('');
  filteredPokemonNames!: Observable<string[]>;


  constructor(
    private cdr: ChangeDetectorRef,
    private pokemonService: PokemonService
  ) { }


  ngOnInit() {
    this.fetchAllPokemonNames(); // fetch names first

    // Setup the filter after names are fetched
    this.filteredPokemonNames = this.searchControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || ''))
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.PokemonNamesList.filter(name => name.toLowerCase().includes(filterValue));
  }



  fetchPokemon(): void {
    const name = this.searchControl.value?.trim();

    if (!name) {
      this.errorMessage = 'Please enter a Pokémon name.';
      this.pokemonData = null;
      return;
    }
    this.getPokemonData(name.toLowerCase());
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
  //       next:(speciesData) => {
  //         // console.log(speciesData.evolution_chain.url);
  //         this.pokemonService.getPokemonDetails(speciesData.evolution_chain.url).subscribe(
  //          {
  //            next:(evolutionsData: any) => { // its a tree!!!!!!
  //             console.log(evolutionsData.chain.species.name) // starter pokemon name
  //             console.log(evolutionsData.chain.species.url) // starter pokeomon url
  //             console.log(evolutionsData.chain.evolves_to[0].species.name);//first evolution name
  //             console.log(evolutionsData.chain.evolves_to[0].species.url); // first evolution url
  //             console.log(evolutionsData.chain.evolves_to[0].evolves_to[0].species.name);//final evolution name
  //             console.log(evolutionsData.chain.evolves_to[0].evolves_to[0].species.url); // final evolution url
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

            // inner method to recursively search the evolution tree for current Pokémon node
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

  fetchAllPokemonNames() {
    this.pokemonService.getAllPokemon().subscribe(
      (entry: any) => {
        // console.log(entry.results);
        entry.results.forEach((value: any) => {
          this.PokemonNamesList.push(value.name);
        })
      }
    );
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
