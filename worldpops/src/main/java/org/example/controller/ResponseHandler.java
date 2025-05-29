package org.example.controller;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseHandler {

    public static ResponseEntity<?> handleResponse(Optional<?> object, String objectType){
        try{
            if (object.isPresent()){
                return ResponseEntity.ok(object.get()); //return a 200 response with a list of cities
            }
            else {
                return ResponseEntity.status(404).body(objectType + " not found with that criteria");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("An error occurred while fetching " + objectType + " " + e.getMessage());
        }
    }
}
