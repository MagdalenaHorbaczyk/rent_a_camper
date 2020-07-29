package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.dto.BookingDto;
import com.kodilla.rentacamperbackend.exception.BookingNotFoundException;
import com.kodilla.rentacamperbackend.facade.BookingFacade;
import com.kodilla.rentacamperbackend.facade.BookingProcessingException;
import com.kodilla.rentacamperbackend.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/bookings")
public class BookingController {

    @Autowired
    BookingMapper bookingMapper;
    @Autowired
    BookingFacade bookingFacade;

    @GetMapping(value = "")
    public List<Booking> getBookings() {
        return bookingFacade.getBookings();
    }

    @GetMapping(value = "/{bookingId}")
    public BookingDto getBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
        return bookingMapper.mapToBookingDto(bookingFacade.getBookingById(bookingId).orElseThrow(BookingNotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void createBooking(@RequestBody Booking booking) throws BookingProcessingException {
        bookingFacade.addBooking(booking);
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public BookingDto updateBooking(@RequestBody Booking booking) throws BookingProcessingException {
        return bookingMapper.mapToBookingDto(bookingFacade.addBooking(booking));
    }

    @DeleteMapping(value = "/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingFacade.deleteBooking(bookingId);
    }
}
