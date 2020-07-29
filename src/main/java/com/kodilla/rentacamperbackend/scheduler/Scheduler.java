package com.kodilla.rentacamperbackend.scheduler;

import com.kodilla.rentacamperbackend.repository.BookingRepository;
import com.kodilla.rentacamperbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class Scheduler {

    @Autowired
    BookingService bookingService;
    @Autowired
    BookingRepository bookingRepository;

    @Scheduled(cron = "0 0 7 * * *")
    public void countForCompletedRentalPeriod() {
        bookingRepository.findAll().stream()
                .filter(booking -> ChronoUnit.DAYS.between(LocalDate.now(), booking.getDropOffDate()) > 0)
                .forEach(booking -> bookingService.countTotalCost(booking));
    }
}
