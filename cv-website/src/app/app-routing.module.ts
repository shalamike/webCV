import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HobbiesInterestsProjectsComponent } from './hobbies-interests-projects/hobbies-interests-projects.component';
import { PokemonComponent } from './pokemon/pokemon.component';

const routes: Routes = [
  { path: '', component: HobbiesInterestsProjectsComponent },
  { path: 'pokemon', component: PokemonComponent }, // New Pokémon route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
