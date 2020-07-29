package com.kodilla.rentacamperbackend.weatherbitForecast.controller;

import com.kodilla.rentacamperbackend.weatherbitForecast.domain.WeatherbitForecastDto;
import com.kodilla.rentacamperbackend.weatherbitForecast.service.WeatherbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/weather")
public class WeatherbitController {

    @Autowired
    private WeatherbitService weatherbitService;

    @GetMapping(value = "/forecast")
    public WeatherbitForecastDto getForecast(@RequestParam(value = "city name") String cityName,
                                             @RequestParam(value = "country code") String countryCode/*,
                                             @RequestParam(value = "data", required = false) List<Forecast> forecastList*/
    ) {
        return weatherbitService.getWeatherForecast(cityName, countryCode);
    }
}
