package com.kodilla.rentacamperbackend.domain;

import com.kodilla.rentacamperbackend.repository.CamperRepository;
import com.kodilla.rentacamperbackend.repository.EquipmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EquipmentTestSuite {

    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    CamperRepository camperRepository;

    @Test
    public void testSaveEquipment() {
        //Given
        Equipment equipment = new Equipment();
        equipment.setDescription("test desc");
        equipment.setBedSet(true);
        equipment.setTowelSet(true);
        equipment.setBikeRack(true);
        equipment.setChildSeat(false);
        equipment.setKitchenKit(true);
        equipment.setSnowChains(false);
        equipment.setWinterTire(false);
        equipment.setCamperList(new ArrayList<>());
        // When
        equipmentRepository.save(equipment);
        Long equipmentId = equipment.getId();
        // Then
        Assert.assertNotNull(equipmentId);
        //Clean-up
        equipmentRepository.deleteById(equipmentId);
    }

    @Test
    public void testReadEquipment() {
        //Given
        Equipment equipment = new Equipment();
        equipment.setDescription("test desc");
        equipment.setBedSet(true);
        equipment.setTowelSet(true);
        equipment.setBikeRack(true);
        equipment.setChildSeat(false);
        equipment.setKitchenKit(true);
        equipment.setSnowChains(false);
        equipment.setWinterTire(false);
        equipment.setCamperList(new ArrayList<>());
        // When
        equipmentRepository.save(equipment);
        Long equipmentId = equipment.getId();
        //Then
        Assert.assertNotNull(equipmentRepository.findById(equipmentId));
        //Clean-up
        equipmentRepository.deleteById(equipmentId);
    }

    @Test
    public void testUpdateEquipment() {
        //Given
        Equipment equipment = new Equipment();
        equipment.setDescription("test des");
        equipment.setBedSet(true);
        equipment.setTowelSet(true);
        equipment.setBikeRack(true);
        equipment.setChildSeat(false);
        equipment.setKitchenKit(true);
        equipment.setSnowChains(false);
        equipment.setWinterTire(false);
        equipment.setCamperList(new ArrayList<>());
        equipmentRepository.save(equipment);
        Long equipmentId = equipment.getId();
        Equipment fetchedEquipment = equipmentRepository.findById(equipmentId).orElse(null);
        assert fetchedEquipment != null;
        String description = fetchedEquipment.getDescription();
        //When
        fetchedEquipment.setDescription("updated test des");
        equipmentRepository.save(fetchedEquipment);
        String updatedDescription = fetchedEquipment.getDescription();
        //Then
        Assert.assertNotEquals(description, updatedDescription);
        //Clean-up
        equipmentRepository.deleteById(equipmentId);
    }
}



