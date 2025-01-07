package org.example.service;

import org.example.model.entities.City;
import org.example.model.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Optional<City> findCityByName(String city){
        try{
            return cityRepository.findByCityName(city);
        }catch (Exception e){
            System.err.println("Error fetching city " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<List<City>> getCitiesByCountryNameAndPopulationGreaterThan(String countryName, int population){
        try{
            return  cityRepository.findCitiesByCountryNameAndPopulationGreaterThan(population,countryName);
        } catch (Exception e){
            System.err.println("Error fetching cities " + e.getMessage());
            return Optional.empty();
        }
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
