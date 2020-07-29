package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.dto.BookingDto;
import com.kodilla.rentacamperbackend.facade.BookingFacade;
import com.kodilla.rentacamperbackend.mapper.BookingMapper;
import com.kodilla.rentacamperbackend.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTestSuite {

    @MockBean
    BookingService bookingService;
    @MockBean
    BookingMapper bookingMapper;
    @MockBean
    BookingFacade bookingFacade;
    @MockBean
    BookingController bookingController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetBookings() throws Exception {
        //Given
        List<Booking> bookingsList = new ArrayList<>();
        Booking booking = new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
        bookingsList.add(booking);
        List<BookingDto> bookingDtoList = new ArrayList<>();
        BookingDto bookingDto = new BookingDto(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "Dto credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
        bookingDtoList.add(bookingDto);
//        when(bookingService.findAllBookings()).thenReturn(bookingsList);
        when(bookingFacade.getBookings()).thenReturn(bookingsList);
//        when(bookingMapper.mapToBookingDtoList(bookingsList)).thenReturn(bookingDtoList);
        //When & Then
        mockMvc.perform(get("/v1/bookings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(1)));
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].paymentMethod", is("Dto credit card")));
    }

    @Test
    public void testGetBooking() throws Exception {
        //Given
        Booking booking = new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
        BookingDto bookingDto = new BookingDto(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "Dto credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
        when(bookingMapper.mapToBookingDto(any(Booking.class))).thenReturn(bookingDto);
        when(bookingFacade.getBookingById(booking.getId())).thenReturn(Optional.of(booking));
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookingDto);
        //When & Then
        mockMvc.perform(get("/v1/bookings/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
//                .andExpect(jsonPath("$.id", is(1)));
//                .andExpect(jsonPath("$.paymentMethod", is("Dto credit card")));
    }
}
