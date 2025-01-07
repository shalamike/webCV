package org.example.model.repositories;


import org.example.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // Find all cities by country code
    Optional<List<City>> findByCountry_Code(String countryCode);

    Optional<City>findByCityName(String city);

    @Query(value = "select ci from City ci join ci.country co " + "\n" +
            "where co.name = :country")
    Optional<List<City>> findByCountryName(String country);

    // Find all cities in a specific district
    Optional<List<City>> findByDistrict(String district);

    // Find all cities with population greater than a given number
    Optional<List<City>> findByPopulationGreaterThan(Integer population);


    @Query(value = "SELECT c FROM City c JOIN c.country co WHERE c.population >= :population AND co.name = :countryName")
    Optional<List<City>> findCitiesByCountryNameAndPopulationGreaterThan(@Param("population") int population, @Param("countryName") String countryName);



}
