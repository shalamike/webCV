import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorldPopulationsServiceService {
  private baseUrl = 'http://10.0.0.1:5000/api';
  private cityUrl = this.baseUrl + '/cities';
  

  constructor(private http: HttpClient) { }

  getCitiesByCountry(country: string): Observable<any> {
    const params = new HttpParams().set('countryName', country);
    return this.http.get<any>(this.cityUrl + "/country", { params });
  }

}
