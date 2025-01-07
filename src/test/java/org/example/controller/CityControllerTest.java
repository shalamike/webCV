package org.example.controller;

import jakarta.persistence.*;
import org.example.model.entities.City;
import org.example.model.entities.Country;
import org.example.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    private List<City> mockCities;

    @BeforeEach
    public void setup(){
        Country mockCountry = new Country();

        String mockCountryCode = "ABC";
        String mockCountryName = "testCountry1";
        String mockCountryRegion = "testRegion";
        String mockCountryContinent = "testContinent";
        float mockCountrySurfaceArea = 12345f;
        Integer mockCountryIndepYear = 1232;
        Integer mockCountryPopulation = 123456;
        Float mockCountryLifeExpectancy;
        Double mockCountryGnp = 12314234242.343;
        Double mockCountryGnpOld = 346457467.234;
        String mockCountryLocalName = "testingCountry";
        String mockCountryGovernmentForm = "dictatorship";
        String mockCountryHeadOfState = "testDictator";
        Integer mockCountryCapital = 94233434;

        City mockCity1 = new City();
        Long mockCityId = 1L;
        String mockCityName = "testCity1";
        String mockDistrict = "testDistrict";
        Integer mockPopulation = 12345;

        City mockCity2 = new City();
        Long mockCityId2 = 2L;
        String mockCityName2 = "mockCity2";
        Integer mockPopulation2 = 67891;

//        mocking the mockCountry
        Mockito.when(mockCountry.getCode()).thenReturn(mockCountryCode);
        Mockito.when(mockCountry.getName()).thenReturn(mockCountryName);



    }

}
