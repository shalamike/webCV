package org.example.controller;

import org.example.model.entities.Country;
import org.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;



    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.findAll();
    }

    @GetMapping("/country")
    public Country findCountryByName(@RequestParam String name){
        return countryService.findCountryByName(name);
    }


}
