import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { WorldPopulationsComponent } from './world-populations/world-populations.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TechStackComponent } from './tech-stack/tech-stack.component';
import { ExperienceComponent } from './experience/experience.component';
import { HobbiesInterestsProjectsComponent } from './hobbies-interests-projects/hobbies-interests-projects.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    WorldPopulationsComponent,
    PokemonComponent,
    TechStackComponent,
    ExperienceComponent,
    HobbiesInterestsProjectsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatExpansionModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
