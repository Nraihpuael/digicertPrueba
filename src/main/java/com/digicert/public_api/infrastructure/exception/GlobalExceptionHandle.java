
package com.digicert.public_api.infrastructure.exception;

import com.digicert.public_api.application.dto.ErrorDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    private static final ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorDTO> handleWebClientResponseException(WebClientResponseException e) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        System.out.println("WebClientResponseException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    
    @ExceptionHandler(WeatherServiceException.class)
    public ResponseEntity<ErrorDTO> handleWeatherServiceException(WeatherServiceException e) {
        String responseBody = e.getMessage();
        JsonNode errorJson;
        try {
            errorJson = mapper.readTree(responseBody);
        } catch (Exception ex) {
            errorJson = mapper.createObjectNode()
                    .put("status", HttpStatus.BAD_REQUEST.value())
                    .put("message", "Invalid error response format");
        }
        
        int statusCode = errorJson.path("cod").asInt(HttpStatus.BAD_REQUEST.value());
        String message = errorJson.path("message").asText("Unknown error");

        ErrorDTO errorDTO = new ErrorDTO(statusCode, message);
        return ResponseEntity.status(HttpStatus.valueOf(statusCode)).body(errorDTO);
    }
    
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred.");
    }
}
