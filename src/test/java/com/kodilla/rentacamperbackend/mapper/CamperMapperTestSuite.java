package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CamperDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CamperMapperTestSuite {

    @Autowired
    private CamperMapper camperMapper;

    private Camper createCamper() {
        return new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
    }

    private CamperDto createCamperDto() {
        return new CamperDto(1L, 8, 6, new BigDecimal(450), new ArrayList<>(),
                new Category(), new ArrayList<>());
    }

    @Test
    public void testMapToCamper() {
        //Given
        CamperDto camperDto = createCamperDto();
        //When
        Camper camper = camperMapper.mapToCamper(camperDto);
        //Then
        assertNotNull(camper);
        assertEquals(Long.valueOf(1), camper.getId());
        assertEquals(8, camper.getSeatsQuantity());
    }

    @Test
    public void testMapToCamperDto() {
        //Given
        Camper camper = createCamper();
        //When
        CamperDto camperDto = camperMapper.mapToCamperDto(camper);
        //Then
        assertNotNull(camper);
        assertEquals(Long.valueOf(1), camper.getId());
        assertEquals(6, camperDto.getSeatsQuantity());
    }

    @Test
    public void testMapToCamperDtoList() {
        //Given
        Camper camper = createCamper();
        List<Camper> camperList = new ArrayList<>();
        camperList.add(camper);
        //When
        List<CamperDto> camperDtoList = camperMapper.mapToCamperDtoList(camperList);
        //Then
        assertNotNull(camperDtoList);
        assertEquals(1, camperDtoList.size());
    }
}
