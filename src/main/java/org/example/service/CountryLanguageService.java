package org.example.service;


import org.example.model.entities.CountryLanguage;
import org.example.model.repositories.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.service.HandleErrors.handleErrorsOrReturn;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;


    public Optional<?> findLanguagesByCountryName(String country){
        return handleErrorsOrReturn(countryLanguageRepository.findLanguagesByCountryName(country));
    }

    public Optional<?> findOfficialLanguageAndSpokenInCountry(String country){
        try{
            Optional<List<CountryLanguage>> languages = countryLanguageRepository.findLanguagesByCountryName(country);

            return Optional.of(languages.get().stream().filter(CountryLanguage::getOfficial).filter(language -> language.getPercentage() >= 50f).collect(Collectors.toList()));
        } catch(Exception e) {
            System.err.println("Error fetching languages " + e.getMessage());
            return Optional.empty();
        }
    }
}
