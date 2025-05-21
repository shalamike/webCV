package org.example.model.repositories;


import org.example.model.entities.Country;
import org.example.model.entities.CountryLanguage;
import org.example.model.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByCountryCode(String countryCode);


    @Query("Select cl from CountryLanguage cl join cl.country co where co.name = :countryName")
    Optional<List<CountryLanguage>> findLanguagesByCountryName(@Param("countryName") String countryName);






}
