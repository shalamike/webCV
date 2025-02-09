import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private pokemonUrl = 'https://pokeapi.co/api/v2/pokemon/';

  constructor(private http: HttpClient) {}

  getPokemonByName(name: string): Observable<any> {
    return this.http.get<any>(`${this.pokemonUrl}${name}`);
  }

  getPokemonAbilitiesDetails(url: string): Observable<any> {
    return this.http.get<any>(url);
  }


}
