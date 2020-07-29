package com.kodilla.rentacamperbackend.weatherbit.config;

import com.kodilla.rentacamperbackend.weatherbitForecast.config.WeatherbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherbitConfigTestSuite {

    @Autowired
    WeatherbitConfig weatherbitConfig;

    @Test
    public void weatherbitConfigTest() {
        assertEquals("https://api.weatherbit.io/v2.0/forecast/daily", weatherbitConfig.getWeatherbitApiEndpoint());
        assertEquals("967c1cca39414c21a24a7c9f2f812b7b", weatherbitConfig.getWeatherbitAppKey());
    }
}
