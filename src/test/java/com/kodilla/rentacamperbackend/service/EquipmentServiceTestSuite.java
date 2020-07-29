package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Equipment;
import com.kodilla.rentacamperbackend.repository.EquipmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentServiceTestSuite {

    @InjectMocks
    EquipmentService equipmentService;
    @Mock
    EquipmentRepository equipmentRepository;

    @Test
    public void getAllEquipmentsTest() {
        //when
        equipmentService.findAllEquipments();
        //then
        verify(equipmentRepository, times(1)).findAll();
    }

    @Test
    public void getEquipmentTest() {
        //given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        //when
        equipmentService.getEquipment(equipment.getId());
        //then
        verify(equipmentRepository, times(1)).findById(1L);
    }

    @Test
    public void saveEquipmentTest() {
        //given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        //when
        equipmentService.saveEquipment(equipment);
        //then
        verify(equipmentRepository, times(1)).save(equipment);
    }

    @Test
    public void deleteEquipmentTest() {
        //given
        Equipment equipment = new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
        //when
        equipmentService.deleteEquipment(equipment.getId());
        //then
        verify(equipmentRepository, times(1)).deleteById(1L);
    }
}
