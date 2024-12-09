package org.example.model.entities;



import jakarta.persistence.*;

@Entity
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "countryCode", nullable = false)
    private Country country;

    private String language;

    @Column(nullable = false)
    private Boolean isOfficial;

    private Float percentage;

    // Getters and Setters
}
