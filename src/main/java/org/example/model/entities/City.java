package org.example.model.entities;



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

    // Getters and Setters
}
