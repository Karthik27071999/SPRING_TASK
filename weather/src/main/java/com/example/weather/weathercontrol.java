package com.example.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class weathercontrol {
    @Autowired
    private weatherservice service;

    @GetMapping("/weather/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        try {

String weatherResponse = service.getDataFromThirdPartyAPI(city);
            return ResponseEntity.ok(weatherResponse);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}