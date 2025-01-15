package org.example.controller;

import org.example.model.entities.Country;
import org.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.example.controller.ResponseHandler.handleResponse;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;



    private String objectType = "country";
    @GetMapping
    public ResponseEntity<?> getAllCountries(){
        return handleResponse(countryService.findAll(), objectType);
    }

    @GetMapping("/country")
    public ResponseEntity<?> findCountryByName(@RequestParam String name){
//        return handleResponse(countryService.findCountryByName(name), objectType);
        try{
            Optional<?> citiesByCountryName = countryService.findCountryByName(name);
            Optional<?> countriesPopulation = countryService.getUrbanPopulationOfCountry(name);
            if (citiesByCountryName.isPresent() && countriesPopulation.isPresent()){
                Map<String, Object> response = new HashMap<>();
                response.put("totalUrbanPopulation",countriesPopulation.get());
                response.put("country", citiesByCountryName.get());
                return ResponseEntity.ok(response); //return a 200 response returns the countries information and the list of cities within the country
            }
            else {
                return ResponseEntity.status(404).body(objectType + " not found with that criteria");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("An error occurred while fetching " + objectType + " " + e.getMessage());
        }
    }

    @GetMapping("/language")
    public ResponseEntity<?> findCountriesWhereLanguageIsOfficial(@RequestParam String language){
        return handleResponse(countryService.findCountriesWhereLanguageIsOfficial(language), objectType);
    }

}
