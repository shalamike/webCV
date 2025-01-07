package org.example.service;


import org.example.model.entities.Country;
import org.example.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.service.HandleErrors.handleErrorsOrReturn;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<?> findCountriesByContinent(String continent){
        return handleErrorsOrReturn(countryRepository.findByContinent(continent));
    }

    public Optional<?> findByPopulationGreaterThan(Integer population){
        return handleErrorsOrReturn(findByPopulationGreaterThan(population));
    }

    public Optional<?>findAll(){
        return handleErrorsOrReturn(Optional.of(countryRepository.findAll()));
    }

    public Optional<?> findCountryByName(String name){

        return handleErrorsOrReturn(countryRepository.findByName(name));
    }

    public Optional<?> findCountriesWhereLanguageIsOfficial(String language){
        return handleErrorsOrReturn(countryRepository.findCountriesWhereLanguageIsOfficial(language));
    }
}
