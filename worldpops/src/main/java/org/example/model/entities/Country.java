package org.example.model.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CountryLanguage> languages;

    @Column(length = 2) // ISO 3166-1 alpha-2 code
    private String code2;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country country)) return false;
        return Objects.equals(code, country.code) && Objects.equals(name, country.name) && Objects.equals(continent, country.continent) && Objects.equals(region, country.region) && Objects.equals(surfaceArea, country.surfaceArea) && Objects.equals(indepYear, country.indepYear) && Objects.equals(population, country.population) && Objects.equals(lifeExpectancy, country.lifeExpectancy) && Objects.equals(gnp, country.gnp) && Objects.equals(gnpOld, country.gnpOld) && Objects.equals(localName, country.localName) && Objects.equals(governmentForm, country.governmentForm) && Objects.equals(headOfState, country.headOfState) && Objects.equals(capital, country.capital) && Objects.equals(code2, country.code2) && Objects.equals(cities, country.cities) && Objects.equals(languages, country.languages);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<CountryLanguage> getLanguages() {
        return languages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2, cities, languages);
    }
}
