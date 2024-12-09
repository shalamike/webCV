package org.example.service;


import org.example.model.entities.CountryLanguage;
import org.example.model.repositories.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    public List<CountryLanguage> findLanguagesByCountryCode(String countryCode){
        return countryLanguageRepository.findByCountryCode(countryCode);
    }

    List<CountryLanguage>findOfficialLanguagesOfCountry(){
        return countryLanguageRepository.findByIsOfficialTrue();
    }

    List<CountryLanguage> findByPercentageGreaterThan(Float percent){
        return findByPercentageGreaterThan(percent);
    }
}
