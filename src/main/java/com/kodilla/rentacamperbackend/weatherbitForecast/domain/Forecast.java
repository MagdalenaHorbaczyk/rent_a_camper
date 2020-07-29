package com.kodilla.rentacamperbackend.weatherbitForecast.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
/*@NoArgsConstructor*/
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
/*
   @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("datetime")
    private String dateTime;

   @JsonProperty("pres")
    private Pres pres;


    @JsonProperty("rh")
    private Rain rain;

    @JsonProperty("snow")
    private Snow snow;

    @JsonProperty("temp")
    private Temp temp;

    @JsonProperty("weather")
    private Weather weather;

    @JsonProperty("wind_spd")
    private Wind windSpeed;*/
}
