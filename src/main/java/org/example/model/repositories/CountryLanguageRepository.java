package org.example.model.repositories;


import org.example.model.entities.CountryLanguage;
import org.example.model.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

}
