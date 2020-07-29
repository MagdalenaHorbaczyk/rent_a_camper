package com.kodilla.rentacamperbackend.domain;

import com.kodilla.rentacamperbackend.repository.BookingRepository;
import com.kodilla.rentacamperbackend.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookingTestSuite {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveBooking() {
        //Given
        Booking booking = new Booking();
        booking.setPickUpDate(LocalDate.of(2020, 5, 5));
        booking.setDropOffDate(LocalDate.of(2020, 5, 15));
        booking.setPaymentMethod("credit card");
        booking.setCost(new BigDecimal("3500.00"));
        // When
        bookingRepository.save(booking);
        Long bookingId = booking.getId();
        // Then
        Assert.assertNotNull(bookingId);
        //Clean-up
        bookingRepository.deleteById(bookingId);
    }

    @Test
    public void testReadBooking() {
        //Given
        Booking booking = new Booking();
        booking.setPickUpDate(LocalDate.of(2020, 5, 5));
        booking.setDropOffDate(LocalDate.of(2020, 5, 15));
        booking.setPaymentMethod("credit card");
        booking.setCost(new BigDecimal("3500.00"));
        // When
        bookingRepository.save(booking);
        Long bookingId = booking.getId();
        //Then
        Assert.assertNotNull(bookingRepository.findById(bookingId));
        //Clean-up
        bookingRepository.deleteById(bookingId);
    }

    @Test
    public void testUpdateBooking() {
        //Given
        Booking booking = new Booking();
        booking.setPickUpDate(LocalDate.of(2020, 5, 5));
        booking.setDropOffDate(LocalDate.of(2020, 5, 15));
        booking.setPaymentMethod("credit card");
        booking.setCost(new BigDecimal("3500.00"));
        bookingRepository.save(booking);
        Long bookingId = booking.getId();
        Booking fetchedBooking = bookingRepository.findById(bookingId).orElse(null);
        assert fetchedBooking != null;
        String paymentMethod = fetchedBooking.getPaymentMethod();
        //When
        fetchedBooking.setPaymentMethod("cash");
        bookingRepository.save(fetchedBooking);
        String updatedPaymentMethod = fetchedBooking.getPaymentMethod();
        //Then
        Assert.assertNotEquals(paymentMethod, updatedPaymentMethod);
        //Clean-up
        bookingRepository.deleteById(bookingId);
    }
}

