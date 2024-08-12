
package com.digicert.public_api.presentation.controller;

import com.digicert.public_api.application.dto.WeatherDTO;
import com.digicert.public_api.application.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping
    public ResponseEntity<?> getWeather(@RequestParam(value = "q", required = false) String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City parameter is required");
        }  
        
        WeatherDTO weatherDTO = weatherService.getWeather(city);
            if (weatherDTO == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(weatherDTO);
    }
    
    
}
