package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.Equipment;
import com.kodilla.rentacamperbackend.domain.dto.EquipmentDto;
import com.kodilla.rentacamperbackend.mapper.EquipmentMapper;
import com.kodilla.rentacamperbackend.service.EquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EquipmentController.class)
public class EquipmentControllerTestSuite {

    @MockBean
    EquipmentService equipmentService;
    @MockBean
    EquipmentMapper equipmentMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetEquipments() throws Exception {
        //Given
        List<Equipment> equipmentList = new ArrayList<>();
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        equipmentList.add(equipment);
        List<EquipmentDto> equipmentDtoList = new ArrayList<>();
        EquipmentDto equipmentDto = new EquipmentDto(1L, "Dto test equipment", false, true,
                true, true, false, false, false, new ArrayList<>());
        equipmentDtoList.add(equipmentDto);
        when(equipmentService.findAllEquipments()).thenReturn(equipmentList);
        when(equipmentMapper.mapToEquipmentDtoList(equipmentList)).thenReturn(equipmentDtoList);
        //When & Then
        mockMvc.perform(get("/v1/equipments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].description", is("Dto test equipment")))
                .andExpect(jsonPath("$[0].bedSet", is(false)));
    }

    @Test
    public void testGetEquipment() throws Exception {
        //Given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        EquipmentDto equipmentDto = new EquipmentDto(1L, "Dto test equipment", false, true,
                true, true, false, false, false, new ArrayList<>());
        when(equipmentService.getEquipment(equipment.getId())).thenReturn(Optional.ofNullable(equipment));
        when(equipmentMapper.mapToEquipmentDto(any(Equipment.class))).thenReturn(equipmentDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(equipmentDto);
        //When & Then
        mockMvc.perform(get("/v1/equipments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("Dto test equipment")))
                .andExpect(jsonPath("$.bedSet", is(false)));
    }

    @Test
    public void shouldUpdateEquipment() throws Exception {
        //Given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        EquipmentDto equipmentDto = new EquipmentDto(1L, "Dto test equipment", false, true,
                true, true, false, false, false, new ArrayList<>());
        when(equipmentMapper.mapToEquipmentDto(equipment)).thenReturn(equipmentDto);
        when(equipmentMapper.mapToEquipment(any(EquipmentDto.class))).thenReturn(equipment);
        when(equipmentService.saveEquipment(equipment)).thenReturn(equipment);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(equipment);
        //When & Then
        mockMvc.perform(put("/v1/equipments")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("Dto test equipment")))
                .andExpect(jsonPath("$.bedSet", is(false)));
    }

    @Test
    public void shouldCreateEquipment() throws Exception {
        //Given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        EquipmentDto equipmentDto = new EquipmentDto(1L, "Dto test equipment", false, true,
                true, true, false, false, false, new ArrayList<>());
        when(equipmentMapper.mapToEquipmentDto(equipment)).thenReturn(equipmentDto);
        when(equipmentMapper.mapToEquipment(any(EquipmentDto.class))).thenReturn(equipment);
        when(equipmentService.saveEquipment(equipment)).thenReturn(equipment);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(equipment);
        //When & Then
        mockMvc.perform(post("/v1/equipments")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
