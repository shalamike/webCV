package org.example;

import org.example.model.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class CountryApiExample
{

    public static final Logger logger = LoggerFactory.getLogger(CountryApiExample.class);

    private final CountryRepository countryRepository;

    public CountryApiExample(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Bean
    public CommandLineRunner runner(CountryRepository countryRepository){
//        return args -> logger.info(countryRepository.findByContinent("Africa").toString());
        return args -> logger.info(countryRepository.findByPopulationGreaterThan(90000).toString());
    }
    public static void main( String[] args )
    {
        SpringApplication.run(CountryApiExample.class, args);
    }



//    @Bean
//    public CommandLineRunner runner(FilmActorService filmActorService) {
//        return args -> {
//            for (Actor a: filmActorService.getActorsByMovieIdJPQL(6)) {
//                logger.info(a.toString());
//            }
//
//        };
//    }
}
