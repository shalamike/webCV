package org.example.service;

import junit.framework.Assert;
import org.example.model.entities.City;
import org.example.model.entities.Country;
import org.example.model.repositories.CityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    public CityServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void beforeEach(){
        Country mockCountry = mock(Country.class);
        when(mockCountry.getName()).thenReturn("TestCountry");

        City city1 = mock(City.class);
        when(city1.getName()).thenReturn("CityOne");
        when(city1.getCountry()).thenReturn(mockCountry);

        City city2 = mock(City.class);
        when(city2.getName()).thenReturn("CityTwo");
        when(city2.getCountry()).thenReturn(mockCountry);

        List<City> mockCities = Arrays.asList(city1, city2);

        when(cityRepository.findByCountryName("TestCountry")).thenReturn(Optional.of(mockCities));
    }

    @Test
    public void testGetCitiesByCountryName(){

        Optional<List<City>> results = cityService.getCitiesByCountryName("TestCountry");

        assertEquals(2, results.get().size());
        assertEquals("CityOne", results.get().get(0).getName());
        assertEquals("CityTwo", results.get().get(1).getName());

        verify(cityRepository, times(1)).findByCountryName("TestCountry");

    }

}
