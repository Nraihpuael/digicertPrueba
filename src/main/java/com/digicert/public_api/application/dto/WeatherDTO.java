
package com.digicert.public_api.application.dto;

import com.digicert.public_api.application.dto.weather.Coord;
import com.digicert.public_api.application.dto.weather.Main;
import com.digicert.public_api.application.dto.weather.Weather;
import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherDTO {      
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("timezone")
    private int timezone;
    
    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("windSpeed")
    private double windSpeed;    

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    
    
    
}
