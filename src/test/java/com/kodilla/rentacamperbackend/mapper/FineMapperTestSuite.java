package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.domain.dto.FineDto;
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
public class FineMapperTestSuite {

    @Autowired
    private FineMapper fineMapper;

    private Fine createFine() {
        return new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
    }

    private FineDto createFineDto() {
        return new FineDto(1L, "Dto test fine", new BigDecimal(3500), new Booking());
    }

    @Test
    public void testMapToFine() {
        //Given
        FineDto fineDto = createFineDto();
        //When
        Fine fine = fineMapper.mapToFine(fineDto);
        //Then
        assertNotNull(fine);
        assertEquals(Long.valueOf(1), fine.getId());
        assertEquals("Dto test fine", fine.getDescription());
    }

    @Test
    public void testMapToFineDto() {
        //Given
        Fine fine = createFine();
        //When
        FineDto fineDto = fineMapper.mapToFineDto(fine);
        //Then
        assertNotNull(fine);
        assertEquals(Long.valueOf(1), fine.getId());
        assertEquals("test fine", fineDto.getDescription());
    }

    @Test
    public void testMapToFineDtoList() {
        //Given
        Fine fine = createFine();
        List<Fine> fineList = new ArrayList<>();
        fineList.add(fine);
        //When
        List<FineDto> fineDtoList = fineMapper.mapToFineDtoList(fineList);
        //Then
        assertNotNull(fineDtoList);
        assertEquals(1, fineDtoList.size());
    }
}


