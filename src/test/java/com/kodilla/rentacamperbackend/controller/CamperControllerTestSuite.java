package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CamperDto;
import com.kodilla.rentacamperbackend.mapper.CamperMapper;
import com.kodilla.rentacamperbackend.service.CamperService;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CamperController.class)
public class CamperControllerTestSuite {
    @MockBean
    CamperService camperService;
    @MockBean
    CamperMapper camperMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetCampers() throws Exception {
        //Given
        List<Camper> camperList = new ArrayList<>();
        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        camperList.add(camper);
        List<CamperDto> camperDtoList = new ArrayList<>();
        CamperDto camperDto = new CamperDto(1L, 8, 8, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        camperDtoList.add(camperDto);
        when(camperService.findAllCampers()).thenReturn(camperList);
        when(camperMapper.mapToCamperDtoList(camperList)).thenReturn(camperDtoList);
        //When & Then
        mockMvc.perform(get("/v1/campers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].seatsQuantity", is(8)))
                .andExpect(jsonPath("$[0].bedsQuantity", is(8)));
    }

//    @Test
//    public void testGetCamper() throws Exception {
//        //Given
//        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
//                new Category(), new ArrayList<>());
//        CamperDto camperDto = new CamperDto(1L, 8, 8, new BigDecimal(450), new ArrayList<>(),
//                new Category(), new ArrayList<>());
//        when(camperService.getCamper(camper.getId())).thenReturn(Optional.ofNullable(camper));
//        when(camperMapper.mapToCamperDto(any(Camper.class))).thenReturn(camperDto);
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(camperDto);
//        //When & Then
//        mockMvc.perform(get("/v1/campers/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent));
//                .andExpect(jsonPath("$.id", is(1)));
//                .andExpect(jsonPath("$.seatsQuantity", is(8)))
//                .andExpect(jsonPath("$.bedsQuantity", is(8)));
//    }

    @Test
    public void shouldUpdateCamper() throws Exception {
        //Given
        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        CamperDto camperDto = new CamperDto(1L, 8, 8, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        when(camperMapper.mapToCamperDto(camper)).thenReturn(camperDto);
        when(camperMapper.mapToCamper(any(CamperDto.class))).thenReturn(camper);
        when(camperService.saveCamper(camper)).thenReturn(camper);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(camper);
        //When & Then
        mockMvc.perform(put("/v1/campers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.seatsQuantity", is(8)))
                .andExpect(jsonPath("$.bedsQuantity", is(8)));
    }

    @Test
    public void shouldAddCamper() throws Exception {
        //Given
        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        CamperDto camperDto = new CamperDto(1L, 8, 8, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
        when(camperMapper.mapToCamperDto(camper)).thenReturn(camperDto);
        when(camperMapper.mapToCamper(any(CamperDto.class))).thenReturn(camper);
        when(camperService.saveCamper(camper)).thenReturn(camper);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(camper);
        //When & Then
        mockMvc.perform(post("/v1/campers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}



