package org.example.service;

import org.example.model.entities.City;
import org.example.model.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getCitiesByCountryCode(String countryCode) {
        return cityRepository.findByCountry_Code(countryCode);
    }

    public List<City> getCitiesWithPopulationGreaterThan(Integer minPopulation) {
        return cityRepository.findByPopulationGreaterThan(minPopulation);
    }

    public List<City> getCitiesByCountryName(String name){
        return cityRepository.findByCountryName(name);
    }
}
