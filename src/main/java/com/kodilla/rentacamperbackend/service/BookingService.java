package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.repository.BookingRepository;
import com.kodilla.rentacamperbackend.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CamperRepository camperRepository;
    @Autowired
    LogService logService;

    public List<Booking> findAllBookings() {
        logService.saveLog("Retrieving all bookings from database");
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBooking(Long id) {
        logService.saveLog("Retrieving booking with id: " + id);
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking) {
        logService.saveLog("Adding booking");
        return bookingRepository.save(booking);
    }

    public Booking imposeFine(Fine fine) {
        fine.getBooking().getCost().add(fine.getCharged());
        fine.getBooking().getFineList().add(fine);
        logService.saveLog("Fine imposed");
        return bookingRepository.save(fine.getBooking());
    }

    public BigDecimal countTotalCost(Booking booking) {

        BigDecimal rentalPeriod = new BigDecimal(ChronoUnit.DAYS.between(booking.getPickUpDate(), booking.getDropOffDate()));
        BigDecimal dailyBookingPrice = booking.getCost();
//        List<Equipment> equipment = booking.getCamper().getEquipmentList();
//        if (equipment.isChildSeat()) {
//            dailyBookingPrice.add(new BigDecimal(50));
//        }
//        if (equipment.isBikeRack()) {
//            dailyBookingPrice.add(new BigDecimal(60));
//        }
//        if (equipment.isBedSet()) {
//            dailyBookingPrice.add(new BigDecimal(30));
//        }
//        if (equipment.isKitchenKit()) {
//            dailyBookingPrice.add(new BigDecimal(30));
//        }
//        if (equipment.isSnowChains()) {
//            dailyBookingPrice.add(new BigDecimal(100));
//        }
//        if (equipment.isTowelSet()) {
//            dailyBookingPrice.add(new BigDecimal(20));
//        }
//        if (equipment.isWinterTire()) {
//            dailyBookingPrice.add(new BigDecimal(50));
//        }
        BigDecimal totalCost = rentalPeriod.multiply(dailyBookingPrice);
        booking.setCost(totalCost);
        bookingRepository.save(booking);
        logService.saveLog("Total cost of " + booking + "is: "+ totalCost);
        return totalCost;
    }

    public void deleteBooking(Long id) {
        logService.saveLog("Removing booking with id: " + id + " from database");
        bookingRepository.deleteById(id);
    }
}
