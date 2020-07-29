package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FineService {

    @Autowired
    FineRepository fineRepository;
    @Autowired
    BookingService bookingService;

    public List<Fine> findAllFines() {
        return fineRepository.findAll();
    }

    public Optional<Fine> getFine(Long id) {
        return fineRepository.findById(id);
    }

    public Fine saveFine(Fine fine) {
        return fineRepository.save(fine);
    }

    public void deleteFine(Long id) {
        fineRepository.deleteById(id);
    }

    public Fine chargeFine(Fine fine) {
        bookingService.imposeFine(fine);
        return fineRepository.save(fine);
    }
}
