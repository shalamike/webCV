package org.example.controller;

import org.example.model.entities.City;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities") // Base URL for the City API
public class CityController {

    @Autowired
    private CityService cityService;

    // Endpoint to get cities by country code
    @GetMapping("/country/{countryCode}")
    public List<City> getCitiesByCountry(@PathVariable String countryCode) {
        return cityService.getCitiesByCountryCode(countryCode);
    }

    @GetMapping("/country")
    public List<City> getCitiesByCountryName(@RequestParam String countryName){
        return cityService.getCitiesByCountryName(countryName);
    }

    // Endpoint to get cities with a large population
    @GetMapping("/population")
    public List<City> getCitiesWithLargePopulation(@RequestParam Integer minPopulation) {
        return cityService.getCitiesWithPopulationGreaterThan(minPopulation);
    }

}
