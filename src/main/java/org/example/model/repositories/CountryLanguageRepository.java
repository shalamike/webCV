package org.example.model.repositories;


import org.example.model.entities.CountryLanguage;
import org.example.model.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    // Find all languages spoken in a specific country
    List<CountryLanguage> findByCountryCode(String countryCode);

    // Find all official languages
    List<CountryLanguage> findByIsOfficialTrue();

    // Find languages spoken by a specific percentage or higher
    List<CountryLanguage> findByPercentageGreaterThan(Float percentage);

}
