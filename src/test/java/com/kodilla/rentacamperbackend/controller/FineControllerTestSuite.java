package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.domain.dto.FineDto;
import com.kodilla.rentacamperbackend.mapper.FineMapper;
import com.kodilla.rentacamperbackend.service.FineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
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
@WebMvcTest(FineController.class)
public class FineControllerTestSuite {

    @MockBean
    FineService fineService;
    @MockBean
    FineMapper fineMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetFines() throws Exception {
        //Given
        List<Fine> fineList = new ArrayList<>();
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        fineList.add(fine);
        List<FineDto> fineDtoList = new ArrayList<>();
        FineDto fineDto = new FineDto(1L, "Dto test fine", new BigDecimal(3500), new Booking());
        fineDtoList.add(fineDto);
        when(fineService.findAllFines()).thenReturn(fineList);
        when(fineMapper.mapToFineDtoList(fineList)).thenReturn(fineDtoList);
        //When & Then
        mockMvc.perform(get("/v1/fines")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].description", is("Dto test fine")));
    }

    @Test
    public void testGetFine() throws Exception {
        //Given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        FineDto fineDto = new FineDto(1L, "Dto test fine", new BigDecimal(3500), new Booking());
        when(fineService.getFine(fine.getId())).thenReturn(Optional.ofNullable(fine));
        when(fineMapper.mapToFineDto(any(Fine.class))).thenReturn(fineDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(fineDto);
        //When & Then
        mockMvc.perform(get("/v1/fines/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("Dto test fine")));
    }

    @Test
    public void shouldUpdateFine() throws Exception {
        //Given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        FineDto fineDto = new FineDto(1L, "Dto test fine", new BigDecimal(3500), new Booking());
        when(fineMapper.mapToFineDto(fine)).thenReturn(fineDto);
        when(fineMapper.mapToFine(any(FineDto.class))).thenReturn(fine);
        when(fineService.saveFine(fine)).thenReturn(fine);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(fine);
        //When & Then
        mockMvc.perform(put("/v1/fines")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("Dto test fine")));
    }

    @Test
    public void shouldCreateFine() throws Exception {
        //Given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        FineDto fineDto = new FineDto(1L, "Dto test fine", new BigDecimal(3500), new Booking());
        when(fineMapper.mapToFineDto(fine)).thenReturn(fineDto);
        when(fineMapper.mapToFine(any(FineDto.class))).thenReturn(fine);
        when(fineService.saveFine(fine)).thenReturn(fine);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(fine);
        //When & Then
        mockMvc.perform(post("/v1/fines")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
