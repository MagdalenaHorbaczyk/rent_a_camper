package com.kodilla.rentacamperbackend.weatherbitForecast.service;

import com.kodilla.rentacamperbackend.weatherbitForecast.client.WeatherbitClient;
import com.kodilla.rentacamperbackend.weatherbitForecast.domain.WeatherbitForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherbitService {

    @Autowired
    private WeatherbitClient weatherbitClient;

    public WeatherbitForecastDto getWeatherForecast(String cityName, String countryCode/*, List<Forecast> forecastList*/) {
        return weatherbitClient.weatherbitForecast(cityName, countryCode/*, forecastList*/);
    }
}
