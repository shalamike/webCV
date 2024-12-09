package org.example.model.repositories;



import org.example.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Find countries by continent
    List<Country> findByContinent(String continent);

    // Find countries by population greater than a specific value
    List<Country> findByPopulationGreaterThan(Integer population);

    // Find a country by name
    Country findByName(String name);

}
