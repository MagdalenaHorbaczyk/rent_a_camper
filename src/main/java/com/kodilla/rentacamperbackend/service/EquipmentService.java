package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Equipment;
import com.kodilla.rentacamperbackend.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public List<Equipment> findAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipment(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
