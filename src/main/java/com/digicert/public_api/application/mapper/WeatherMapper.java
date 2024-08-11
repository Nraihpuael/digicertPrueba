
package com.digicert.public_api.application.mapper;

import com.digicert.public_api.application.dto.WeatherDTO;
import com.digicert.public_api.application.dto.weather.Coord;
import com.digicert.public_api.application.dto.weather.Main;
import com.digicert.public_api.application.dto.weather.Weather;
import com.fasterxml.jackson.databind.JsonNode;


public class WeatherMapper {
    
    public static WeatherDTO toDTO(JsonNode weatherJson) {
        WeatherDTO weatherDTO = new WeatherDTO();
      
        
        if (weatherJson.has("name")) {
            weatherDTO.setName(weatherJson.get("name").asText(""));
        }
        
        if (weatherJson.has("timezone")) {
            weatherDTO.setTimezone(weatherJson.get("timezone").asInt(0));
        }
        
        if (weatherJson.has("coord")) {
            JsonNode coordNode = weatherJson.get("coord");
            Coord coord = new Coord();
            coord.setLon(coordNode.get("lon").asDouble(0.0));
            coord.setLat(coordNode.get("lat").asDouble(0.0));
            weatherDTO.setCoord(coord);
        }

        if (weatherJson.has("weather")) {
            JsonNode weatherArray = weatherJson.get("weather");
            Weather[] weatherArrayDTO = new Weather[weatherArray.size()];
            for (int i = 0; i < weatherArray.size(); i++) {
                JsonNode weatherNode = weatherArray.get(i);
                Weather weather = new Weather();
                weather.setMain(weatherNode.get("main").asText(""));
                weather.setDescription(weatherNode.get("description").asText(""));
                weatherArrayDTO[i] = weather;
            }
            weatherDTO.setWeather(weatherArrayDTO);
        }

        if (weatherJson.has("main")) {
            JsonNode mainNode = weatherJson.get("main");
            Main main = new Main();
            main.setTemp(mainNode.get("temp").asDouble(0.0));
            main.setTempMin(mainNode.get("temp_min").asDouble(0.0));
            main.setTempMax(mainNode.get("temp_max").asDouble(0.0));
            main.setPressure(mainNode.get("pressure").asInt(0));
            main.setHumidity(mainNode.get("humidity").asInt(0));
            weatherDTO.setMain(main);
        }

        if (weatherJson.has("wind")) {
            JsonNode windNode = weatherJson.get("wind");
            if (windNode.has("speed")) {
                weatherDTO.setWindSpeed(windNode.get("speed").asDouble(0.0));
            }
        }

        return weatherDTO;
    
    }
    
}
