
package com.digicert.public_api.application.service;

import com.digicert.public_api.application.dto.WeatherDTO;


public interface WeatherService {
    public WeatherDTO getWeather(String city);

}
