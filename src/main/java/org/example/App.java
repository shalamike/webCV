package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{

    public static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
