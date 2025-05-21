package org.example.service;

import java.util.Optional;

public class HandleErrors {

    public static Optional<?> handleErrorsOrReturn(Optional<?> object, String objectType){
        try{
            return object;
        } catch (Exception e){
            System.err.println("Error fetching " + objectType + " " + e.getMessage());
            return Optional.empty();
        }
    }
}
