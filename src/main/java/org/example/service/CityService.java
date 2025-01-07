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
    @Autowired
    private CityRepository cityRepository;

    public Optional<List<City>> getCitiesByCountryCode(String countryCode) {
        try{
            return cityRepository.findByCountry_Code(countryCode);
        } catch (Exception e){
            System.err.println("Error fetching cities " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<List<City>> getCitiesWithPopulationGreaterThan(Integer minPopulation) {
        try{
            return cityRepository.findByPopulationGreaterThan(minPopulation);
        } catch (Exception e){
            System.err.println("Error fetching cities " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<?> findCityByName(String city){
        return handleErrorsOrReturn(cityRepository.findByName(city));
    }

    public Optional<?> getCitiesByCountryNameAndPopulationGreaterThan(String countryName, int population){

        return handleErrorsOrReturn(cityRepository.findCitiesByCountryNameAndPopulationGreaterThan(population,countryName));
    }

    public Optional<List<City>> getCitiesByCountryName(String name){
        try{
            return cityRepository.findByCountryName(name);
        } catch (Exception e){
            System.err.println("Error fetching cities " + e.getMessage());
            return Optional.empty();
        }

    }
}
