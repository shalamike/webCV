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

    public List<City> getCitiesByCountry(String countryCode) {
        return cityRepository.findByCountry_Code(countryCode);
    }

    public List<City> getCitiesWithLargePopulation(Integer minPopulation) {
        return cityRepository.findByPopulationGreaterThan(minPopulation);
    }
}
