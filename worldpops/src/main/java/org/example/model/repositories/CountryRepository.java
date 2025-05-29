package org.example.model.repositories;



import org.example.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {


    // Find countries by continent
    Optional<List<Country>> findByContinent(String continent);

    // Find countries by population greater than a specific value
    Optional<List<Country>> findByPopulationGreaterThan(Integer population);

    // Find a country by name
    @Query(value = "select c from Country c where c.name = :name")
    Optional<Country> findByName(@Param("name") String name);

    //find countries where a given language is the official language

    @Query(value = "select c from Country c Join c.languages l where l.isOfficial = true and l.language = :spokenLanguage")
    Optional<List<Country>> findCountriesWhereLanguageIsOfficial(@Param("spokenLanguage") String spokenLanguage);

}
