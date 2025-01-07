package org.example.controller;

import org.example.model.entities.Country;
import org.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        return handleResponse(countryService.findCountryByName(name), objectType);
    }

    @GetMapping("/language")
    public ResponseEntity<?> findCountriesWhereLanguageIsOfficial(@RequestParam String language){
        return handleResponse(countryService.findCountriesWhereLanguageIsOfficial(language), objectType);
    }

}
