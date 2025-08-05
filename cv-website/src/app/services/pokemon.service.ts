import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private pokemonUrl = 'https://pokeapi.co/api/v2/pokemon/';
  private allPokemonsUrl = 'https://pokeapi.co/api/v2/pokemon?limit=1302'

  constructor(private http: HttpClient) {}

  getPokemonByName(name: string): Observable<any> {
    return this.http.get<any>(`${this.pokemonUrl}${name}`);
  }

  getPokemonDetails(url: string): Observable<any> {
    return this.http.get<any>(url)
  }

  getAllPokemon(): Observable<any>{
    return this.http.get<any>(`${this.allPokemonsUrl}`);
  }
}
