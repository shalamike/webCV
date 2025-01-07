package org.example.service;


import org.example.model.entities.Country;
import org.example.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<List<Country>> findCountriesByContinent(String continent){
        return countryRepository.findByContinent(continent);
    }

    public Optional<List<Country>> findByPopulationGreaterThan(Integer population){
        return findByPopulationGreaterThan(population);
    }

    public Optional<List<Country>>findAll(){
        return Optional.of(countryRepository.findAll());
    }

    public Optional<Country> findCountryByName(String name){
        return countryRepository.findByName(name);
    }

    public Optional<List<Country>> findCountriesWhereLanguageIsOfficial(String language){
        return countryRepository.findCountriesWhereLanguageIsOfficial(language);
    }
}
