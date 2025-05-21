package org.example.service;


import org.example.model.entities.City;
import org.example.model.entities.Country;
import org.example.model.repositories.CityRepository;
import org.example.model.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.example.service.HandleErrors.handleErrorsOrReturn;

@Service
public class CountryService {
    private String objectType = "country";
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    public Optional<?> findCountriesByContinent(String continent){
        return handleErrorsOrReturn(countryRepository.findByContinent(continent), objectType);
    }

    public Optional<?> findByPopulationGreaterThan(Integer population){
        return handleErrorsOrReturn(findByPopulationGreaterThan(population), objectType);
    }

    public Optional<?>findAll(){
        return handleErrorsOrReturn(Optional.of(countryRepository.findAll()), objectType);
    }

    public Optional<?> findCountryByName(String name){

        return handleErrorsOrReturn(countryRepository.findByName(name), objectType);
    }

    public Optional<?> findCountriesWhereLanguageIsOfficial(String language){
        return handleErrorsOrReturn(countryRepository.findCountriesWhereLanguageIsOfficial(language), objectType);
    }

    public Optional<?> getUrbanPopulationOfCountry(String name){
        try{

            return Optional.of(cityRepository.findByCountryName(name).get().
                    stream().
                    mapToLong(City::getPopulation)
                    .sum());
        } catch (Exception e){
            System.err.println("Error fetching " + objectType + " " + e.getMessage());
            return Optional.empty();
        }
    }
}
