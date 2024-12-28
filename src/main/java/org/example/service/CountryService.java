package org.example.service;


import org.example.model.entities.Country;
import org.example.model.entities.CountryLanguage;
import org.example.model.repositories.CityRepository;
import org.example.model.repositories.CountryLanguageRepository;
import org.example.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findCountriesByContinent(String continent){
        return countryRepository.findByContinent(continent);
    }

    public List<Country> findByPopulationGreaterThan(Integer population){
        return findByPopulationGreaterThan(population);
    }

    public List<Country>findAll(){
        return countryRepository.findAll();
    }

    public Country findCountryByName(String name){
        return countryRepository.findByName(name);
    }
}
