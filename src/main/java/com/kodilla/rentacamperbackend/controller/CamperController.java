package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CamperDto;
import com.kodilla.rentacamperbackend.exception.CamperNotFoundException;
import com.kodilla.rentacamperbackend.mapper.CamperMapper;
import com.kodilla.rentacamperbackend.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/campers")
public class CamperController {

    @Autowired
    CamperService camperService;
    @Autowired
    CamperMapper camperMapper;

    @GetMapping(value = "")
    public List<CamperDto> getCampers() {
        return camperMapper.mapToCamperDtoList((camperService.findAllCampers()));
    }

    @GetMapping(value = "/{camperId}")
    public CamperDto getCamper(@PathVariable Long camperId) throws CamperNotFoundException {
        return camperMapper.mapToCamperDto(camperService.getCamper(camperId).orElseThrow(CamperNotFoundException::new));
    }

    @GetMapping(value = "/{seatsQuantity}")
    public List<CamperDto> getCampersBySeatsQuantity(@PathVariable int seatsQuantity) {
        return camperMapper.mapToCamperDtoList(camperService.findCampersBySeatsQuantity(seatsQuantity));
    }

    @GetMapping(value = "/{dailyRentPrice}")
    public List<CamperDto> getCampersByDailyRentPrice(@PathVariable BigDecimal dailyRentPrice) {
        return camperMapper.mapToCamperDtoList(camperService.findCampersByDailyRentPrice(dailyRentPrice));
    }

    @GetMapping(value = "/{category}")
    public List<CamperDto> getCampersByCategory(@PathVariable Category category) {
        return camperMapper.mapToCamperDtoList(camperService.findCampersByCategory(category));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void addCamper(@RequestBody CamperDto camperDto) {
        camperService.saveCamper(camperMapper.mapToCamper(camperDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public CamperDto updateCamper(@RequestBody CamperDto camperDto) {
        return camperMapper.mapToCamperDto(camperService.saveCamper(camperMapper.mapToCamper(camperDto)));
    }

    @DeleteMapping(value = "/{camperId}")
    public void deleteCamper(@PathVariable Long camperId) {
        camperService.deleteCamper(camperId);
    }
}
