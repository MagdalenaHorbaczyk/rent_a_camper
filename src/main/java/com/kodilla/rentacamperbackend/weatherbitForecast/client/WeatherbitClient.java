package com.kodilla.rentacamperbackend.weatherbitForecast.client;

import com.kodilla.rentacamperbackend.weatherbitForecast.config.WeatherbitConfig;
import com.kodilla.rentacamperbackend.weatherbitForecast.domain.WeatherbitForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherbitClient {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private WeatherbitConfig weatherbitConfig;

    public WeatherbitForecastDto weatherbitForecast(String cityName, String countryCode) {
        return restTemplate.getForObject(getUrl(cityName, countryCode, weatherbitConfig.getWeatherbitApiEndpoint()),
                WeatherbitForecastDto.class);
    }

    private URI getUrl(String cityName, String countryCode, String endpoint) {

        URI url = UriComponentsBuilder.fromHttpUrl(weatherbitConfig.getWeatherbitApiEndpoint())
                .queryParam("city", cityName, countryCode)
                .queryParam("days", 7)
                .queryParam("units", "S")
                .queryParam("lang", "pl")
                .queryParam("key", weatherbitConfig.getWeatherbitAppKey())
                .build().encode().toUri();
        return url;
    }
}
