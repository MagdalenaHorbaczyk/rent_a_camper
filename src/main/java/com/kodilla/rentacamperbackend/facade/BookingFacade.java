package com.kodilla.rentacamperbackend.facade;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.dto.BookingDto;
import com.kodilla.rentacamperbackend.mapper.BookingMapper;
import com.kodilla.rentacamperbackend.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingFacade.class);

    @Autowired
    private BookingService bookingService;
    @Autowired
    BookingMapper bookingMapper;

    public List<Booking> getBookings() {
        return bookingService.findAllBookings();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingService.getBooking(id);
    }

    public Booking addBooking(Booking booking) throws BookingProcessingException {
        BookingDto bookingDto = bookingMapper.mapToBookingDto(booking);
        Long bookingId = bookingService.saveBooking(booking).getId();
        if (bookingId < 0) {
            LOGGER.error(BookingProcessingException.ERR_NOT_AUTHORISED);
            throw new BookingProcessingException(BookingProcessingException.ERR_NOT_AUTHORISED);
        }
        return bookingService.saveBooking(bookingMapper.mapToBooking(bookingDto));
    }

    public void deleteBooking(Long id) {
        bookingService.deleteBooking(id);
    }
}


