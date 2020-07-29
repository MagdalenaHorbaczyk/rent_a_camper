package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.dto.EquipmentDto;
import com.kodilla.rentacamperbackend.exception.EquipmentNotFoundException;
import com.kodilla.rentacamperbackend.mapper.EquipmentMapper;
import com.kodilla.rentacamperbackend.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/equipments")
public class EquipmentController {

    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    EquipmentService equipmentService;

    @GetMapping(value = "")
    public List<EquipmentDto> getEquipments() {
        return equipmentMapper.mapToEquipmentDtoList((equipmentService.findAllEquipments()));
    }

    @GetMapping(value = "/{equipmentId}")
    public EquipmentDto getEquipment(@PathVariable Long equipmentId) throws EquipmentNotFoundException {
        return equipmentMapper.mapToEquipmentDto(equipmentService.getEquipment(equipmentId).orElseThrow(EquipmentNotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void createEquipment(@RequestBody EquipmentDto equipmentDto) {
        equipmentService.saveEquipment(equipmentMapper.mapToEquipment(equipmentDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public EquipmentDto updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        return equipmentMapper.mapToEquipmentDto(equipmentService.saveEquipment(equipmentMapper.mapToEquipment(equipmentDto)));
    }

    @DeleteMapping(value = "/{equipmentId}")
    public void deleteEquipment(@PathVariable Long equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
    }
}



