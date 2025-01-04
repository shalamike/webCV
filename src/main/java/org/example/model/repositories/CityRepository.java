package org.example.model.repositories;


import org.example.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // Find all cities by country code
    List<City> findByCountry_Code(String countryCode);


    @Query(value = "select ci from City ci join ci.country co " + "\n" +
            "where co.name = :country")
    List<City> findByCountryName(String country);

    // Find all cities in a specific district
    List<City> findByDistrict(String district);

    // Find all cities with population greater than a given number
    List<City> findByPopulationGreaterThan(Integer population);



}
