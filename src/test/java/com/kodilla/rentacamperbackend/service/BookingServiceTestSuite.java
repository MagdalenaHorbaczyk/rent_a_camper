//package com.kodilla.rentacamperbackend.service;
//
//import com.kodilla.rentacamperbackend.domain.Booking;
//import com.kodilla.rentacamperbackend.domain.Camper;
//import com.kodilla.rentacamperbackend.domain.User;
//import com.kodilla.rentacamperbackend.repository.BookingRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class BookingServiceTestSuite {
//
//    @InjectMocks
//    BookingService bookingService;
//    @Mock
//    BookingRepository bookingRepository;
//
//    @Test
//    public void findAllBookingsTest() {
//        //when
//        bookingService.findAllBookings();
//        //then
//        verify(bookingRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void getBookingTest() {
//        //given
//        Booking booking = new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
//                LocalDate.of(2020, 5, 15), "credit card",
//                new BigDecimal("3500.00"), new ArrayList<>());
//        //when
//        bookingService.getBooking(booking.getId());
//        //then
//        verify(bookingRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    public void saveBookingTest() {
//        //given
//        Booking booking = new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
//                LocalDate.of(2020, 5, 15), "credit card",
//                new BigDecimal("3500.00"), new ArrayList<>());
//        //when
//        bookingService.saveBooking(booking);
//        //then
//        verify(bookingRepository, times(1)).save(booking);
//    }
//
//    @Test
//    public void deleteBookingTest() {
//        //given
//        Booking booking = new Booking(1L, new User(), new Camper(), LocalDate.of(2020, 5, 5),
//                LocalDate.of(2020, 5, 15), "credit card",
//                new BigDecimal("3500.00"), new ArrayList<>());
//        //when
//        bookingService.deleteBooking(booking.getId());
//        //then
//        verify(bookingRepository, times(1)).deleteById(1L);
//    }
//}