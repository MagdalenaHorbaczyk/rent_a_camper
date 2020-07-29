package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.repository.FineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class FineServiceTestSuite {

    @InjectMocks
    FineService fineService;
    @Mock
    FineRepository fineRepository;

    @Test
    public void findAllFinesTest() {
        //when
        fineService.findAllFines();
        //then
        verify(fineRepository, times(1)).findAll();
    }

    @Test
    public void getFineTest() {
        //given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        //when
        fineService.getFine(fine.getId());
        //then
        verify(fineRepository, times(1)).findById(1L);
    }

    @Test
    public void saveFineTest() {
        //given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        //when
        fineService.saveFine(fine);
        //then
        verify(fineRepository, times(1)).save(fine);
    }

    @Test
    public void deleteFineTest() {
        //given
        Fine fine = new Fine(1L, "test fine", new BigDecimal(3500), new Booking());
        //when
        fineService.deleteFine(fine.getId());
        //then
        verify(fineRepository, times(1)).deleteById(1L);
    }
}
