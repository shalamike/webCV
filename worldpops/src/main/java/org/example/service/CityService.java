package org.example.service;

import org.example.model.entities.City;
import org.example.model.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


import static org.example.service.HandleErrors.handleErrorsOrReturn;

@Service
public class CityService {

    String objectType = "city";
    @Autowired
    private CityRepository cityRepository;

    public Optional<?> getCitiesByCountryCode(String countryCode) {
        return handleErrorsOrReturn(cityRepository.findByCountry_Code(countryCode), objectType);

    }

    public Optional<?> getCitiesWithPopulationGreaterThan(Integer minPopulation) {
        return handleErrorsOrReturn(cityRepository.findByPopulationGreaterThan(minPopulation), objectType);
    }

    public Optional<?> findCityByName(String city){
        return handleErrorsOrReturn(cityRepository.findByName(city), objectType);
    }

    public Optional<?> getCitiesByCountryNameAndPopulationGreaterThan(String countryName, int population){
        return handleErrorsOrReturn(cityRepository.findCitiesByCountryNameAndPopulationGreaterThan(population,countryName), objectType);
    }

    public Optional<?> getCitiesByCountryName(String name){
        return handleErrorsOrReturn(cityRepository.findByCountryName(name), objectType);
    }
}
