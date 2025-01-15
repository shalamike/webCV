package org.example.model.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CountryLanguage {

    @EmbeddedId
    @JsonIgnore
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "countryCode", nullable = false)
    private Country country;

    @Column(insertable = false, updatable = false)
    private String language;

    public CountryLanguageId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguage that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getLanguage(), that.getLanguage()) && Objects.equals(isOfficial, that.isOfficial) && Objects.equals(getPercentage(), that.getPercentage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getLanguage(), isOfficial, getPercentage());
    }

    @JsonIgnore
    public Country getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    @Column(nullable = false)
    private Boolean isOfficial;

    private Float percentage;

    // Getters and Setters
}
