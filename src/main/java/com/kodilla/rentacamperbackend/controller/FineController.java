package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.dto.FineDto;
import com.kodilla.rentacamperbackend.exception.FineNotFoundException;
import com.kodilla.rentacamperbackend.mapper.FineMapper;
import com.kodilla.rentacamperbackend.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/fines")
public class FineController {

    @Autowired
    FineMapper fineMapper;
    @Autowired
    FineService fineService;

    @GetMapping(value = "")
    public List<FineDto> getFines() {
        return fineMapper.mapToFineDtoList((fineService.findAllFines()));
    }

    @GetMapping(value = "/{fineId}")
    public FineDto getFine(@PathVariable Long fineId) throws FineNotFoundException {
        return fineMapper.mapToFineDto(fineService.getFine(fineId).orElseThrow(FineNotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void createFine(@RequestBody FineDto fineDto) {
        fineService.saveFine(fineMapper.mapToFine(fineDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public FineDto updateFine(@RequestBody FineDto fineDto) {
        return fineMapper.mapToFineDto(fineService.saveFine(fineMapper.mapToFine(fineDto)));
    }

    @DeleteMapping(value = "/{fineId}")
    public void deleteFine(@PathVariable Long fineId) {
        fineService.deleteFine(fineId);
    }
}

