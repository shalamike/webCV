package org.example.model.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @Column(length = 3) // ISO 3166-1 alpha-3 code
    private String code;

    @Column(nullable = false)
    private String name;

    private String continent;
    private String region;
    private Float surfaceArea;
    private Integer indepYear;
    private Integer population;
    private Float lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;

    @Column(length = 2) // ISO 3166-1 alpha-2 code
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CountryLanguage> languages;

    // Getters and Setters
}
