package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CamperService {

    @Autowired
    CamperRepository camperRepository;
    @Autowired
    LogService logService;

    public List<Camper> findAllCampers() {
        logService.saveLog("Retrieving all campers from database");
        return camperRepository.findAll();
    }

    public Optional<Camper> getCamper(Long id) {
        logService.saveLog("Retrieving camper with id: " + id);
        return camperRepository.findById(id);
    }

    public Camper saveCamper(Camper camper) {
        logService.saveLog("Adding camper");
        return camperRepository.save(camper);
    }

    public void deleteCamper(Long id) {
        logService.saveLog("Removing camper with id: " + id + " from database");
        camperRepository.deleteById(id);
    }

    public List<Camper> findCampersBySeatsQuantity(int seatsQuantity) {
        logService.saveLog("Retrieving campers with seats quantity: " + seatsQuantity);
        return camperRepository.findAllCampersBySeatsQuantity(seatsQuantity);
    }

    public List<Camper> findCampersByDailyRentPrice(BigDecimal dailyRentPrice) {
        logService.saveLog("Retrieving campers with daily rent price: " + dailyRentPrice);
        return camperRepository.findAllCampersByDailyRentPrice(dailyRentPrice);
    }

    public List<Camper> findCampersByCategory(Category category) {
        logService.saveLog("Retrieving campers with category: " + category);
        return camperRepository.findAllCampersByCategory(category);
    }
}
