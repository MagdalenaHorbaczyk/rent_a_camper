package com.kodilla.rentacamperbackend.weatherbitForecast.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Component
public class WeatherbitConfig {
    @Value("${weatherbit.api.endpoint.prod}")
    private String weatherbitApiEndpoint;
    @Value("${weatherbit.app.key}")
    private String weatherbitAppKey;

}

