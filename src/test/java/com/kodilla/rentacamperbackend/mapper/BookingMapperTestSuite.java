package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.dto.BookingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingMapperTestSuite {

    @Autowired
    private BookingMapper bookingMapper;

    private Booking createBooking() {
        return new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
    }

    private BookingDto createBookingDto() {
        return new BookingDto(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
                LocalDate.of(2020, 5, 15), "credit card",
                new BigDecimal("3500.00"), new ArrayList<>());
    }

    @Test
    public void testMapToBooking() {
        //Given
        BookingDto bookingDto = createBookingDto();
        //When
        Booking booking = bookingMapper.mapToBooking(bookingDto);
        //Then
        assertNotNull(booking);
        assertEquals(Long.valueOf(1), booking.getId());
        assertEquals("credit card", booking.getPaymentMethod());
    }

    @Test
    public void testMapToBookingDto() {
        //Given
        Booking booking = createBooking();
        //When
        BookingDto bookingDto = bookingMapper.mapToBookingDto(booking);
        //Then
        assertNotNull(booking);
        assertEquals(Long.valueOf(1), booking.getId());
        assertEquals("credit card", bookingDto.getPaymentMethod());
    }

    @Test
    public void testMapToBookingDtoList() {
        //Given
        Booking booking = createBooking();
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        //When
        List<BookingDto> bookingDtoList = bookingMapper.mapToBookingDtoList(bookingList);
        //Then
        assertNotNull(bookingDtoList);
        assertEquals(1, bookingDtoList.size());
    }
}
