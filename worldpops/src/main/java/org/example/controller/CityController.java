package org.example.controller;

import org.example.model.entities.City;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.example.controller.ResponseHandler.handleResponse;

@RestController
@RequestMapping("/api/cities") // Base URL for the City API
public class CityController {

    @Autowired
    private CityService cityService;

    private String objectType = "City";

    // Endpoint to get cities by country code
    @GetMapping("/country/{countryCode}")
    public ResponseEntity<?> getCitiesByCountry(@PathVariable String countryCode) {
        return handleResponse(cityService.getCitiesByCountryCode(countryCode), objectType);
    }

    @GetMapping("/country")
    public ResponseEntity<?> getCitiesByCountryName(@RequestParam String countryName){
        return handleResponse(cityService.getCitiesByCountryName(countryName), objectType);
    }

    // Endpoint to get cities with a large population
    @GetMapping("/allpopulations")
    public ResponseEntity<?> getCitiesWithLargePopulation(@RequestParam Integer minPopulation) {
        return handleResponse(cityService.getCitiesWithPopulationGreaterThan(minPopulation), objectType);
    }

    @GetMapping("/population")
    public ResponseEntity<?> getCitiesWithLargePopulationInCountry(@RequestParam String country, @RequestParam Integer minPopulation){
        return handleResponse(cityService.getCitiesByCountryNameAndPopulationGreaterThan(country,minPopulation), objectType);
    }
}
