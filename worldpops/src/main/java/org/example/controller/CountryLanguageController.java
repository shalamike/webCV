package org.example.controller;

import org.apache.coyote.Response;
import org.example.model.entities.CountryLanguage;
import org.example.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.example.controller.ResponseHandler.handleResponse;

@RestController
@RequestMapping("api/languages")
public class CountryLanguageController {

    @Autowired
    private CountryLanguageService countryLanguageService;

    private String objectType = "language";

    @GetMapping("/countrylanguages")
    public ResponseEntity<?> findLanguagesByCountryName(@RequestParam String name){
        return handleResponse(countryLanguageService.findLanguagesByCountryName(name), objectType);
    }

    @GetMapping("/countrymainlanguages")
    public ResponseEntity<?> findOfficialAndSPokenLanguageByCountryName(@RequestParam String name){
        return handleResponse(countryLanguageService.findOfficialLanguageAndSpokenInCountry(name), objectType);
    }
}
