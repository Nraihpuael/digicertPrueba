
package com.digicert.public_api.application.service.impl;

import com.digicert.public_api.application.dto.WeatherDTO;
import com.digicert.public_api.application.mapper.WeatherMapper;
import com.digicert.public_api.application.service.WeatherService;
import com.digicert.public_api.infrastructure.exception.WeatherServiceException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WebClient webClient;
    private final String apiKey;

    public WeatherServiceImpl(WebClient.Builder webClientBuilder,
                          @Value("${weather.api.key}") String apiKey ,
                          @Value("${weather.api.url}") String url ) {
        this.webClient = webClientBuilder
                .baseUrl(url)
                .build();
        this.apiKey = apiKey;
    }

    
    @Override
    public WeatherDTO getWeather(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City parameter cannot be empty");
        }
        try {
            JsonNode response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/weather")
                            .queryParam("q", city)
                            .queryParam("appid", apiKey)
                            .queryParam("units", "metric")
                            .build())
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();
             WeatherDTO weatherDTO = WeatherMapper.toDTO(response);
             return weatherDTO;
             
        } catch (WebClientResponseException e) {
            String responseBody = e.getResponseBodyAsString();
            throw new WeatherServiceException(responseBody);

        } catch (Exception e) {
            throw new WeatherServiceException("Unexpected error occurred");
        }

    }

   
    
}
