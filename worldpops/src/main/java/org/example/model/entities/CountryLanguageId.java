package org.example.model.entities;



import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    private String countryCode;
    private String language;

    // Default constructor
    public CountryLanguageId() {}

    // Parameterized constructor
    public CountryLanguageId(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguageId that)) return false;
        return Objects.equals(getCountryCode(), that.getCountryCode()) && Objects.equals(getLanguage(), that.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode(), getLanguage());
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }
// Getters, Setters, equals(), and hashCode()

}

