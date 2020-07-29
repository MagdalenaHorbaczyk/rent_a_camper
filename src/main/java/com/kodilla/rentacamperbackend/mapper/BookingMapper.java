package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.dto.BookingDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    public Booking mapToBooking(final BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                bookingDto.getUser(),
                bookingDto.getCamper(),
                bookingDto.getPickUpDate(),
                bookingDto.getDropOffDate(),
                bookingDto.getPaymentMethod(),
                bookingDto.getCost(),
                bookingDto.getFineList());
    }

    public BookingDto mapToBookingDto(final Booking booking) {
        return new BookingDto.BookingDtoBuilder()
                .id(booking.getId())
                .user(booking.getUser())
                .camper(booking.getCamper())
                .pickUpDate(booking.getPickUpDate())
                .dropOffDate(booking.getDropOffDate())
                .paymentMethod(booking.getPaymentMethod())
                .cost(booking.getCost())
                .fineList(booking.getFineList())
                .build();
    }

    public List<BookingDto> mapToBookingDtoList(final List<Booking> bookingList) {
        return bookingList.stream()
                .map(t -> new BookingDto(t.getId(), t.getUser(), t.getCamper(), t.getPickUpDate(), t.getDropOffDate(), t.getPaymentMethod(),
                        t.getCost(), t.getFineList()))
                .collect(Collectors.toList());
    }
}
