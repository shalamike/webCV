package org.example.model.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryCode", nullable = false)
    private Country country;

    private String district;
    private Integer population;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Country getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getPopulation() {
        return population;
    }


    // Getters and Setters
}
