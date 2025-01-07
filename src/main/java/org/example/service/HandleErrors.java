package org.example.service;

import java.util.Optional;

public class HandleErrors {

    public static Optional<?> handleErrorsOrReturn(Optional<?> object){
        try{
            return object;
        } catch (Exception e){
            System.err.println("Error fetching cities " + e.getMessage());
            return Optional.empty();
        }
    }
}
