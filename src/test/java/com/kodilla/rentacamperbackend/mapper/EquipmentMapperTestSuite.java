package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Equipment;
import com.kodilla.rentacamperbackend.domain.dto.EquipmentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentMapperTestSuite {

    @Autowired
    private EquipmentMapper equipmentMapper;

    private Equipment createEquipment() {
        return new Equipment(1L, "test equipment", true, true,
                true, true, false, false, false, new ArrayList<>());
    }

    private EquipmentDto createEquipmentDto() {
        return new EquipmentDto(1L, "Dto test equipment", false, true,
                true, true, false, false, false, new ArrayList<>());
    }

    @Test
    public void testMapToEquipment() {
        //Given
        EquipmentDto equipmentDto = createEquipmentDto();
        //When
        Equipment equipment = equipmentMapper.mapToEquipment(equipmentDto);
        //Then
        assertNotNull(equipment);
        assertEquals(Long.valueOf(1), equipment.getId());
        assertEquals("Dto test equipment", equipment.getDescription());
    }

    @Test
    public void testMapToEquipmentDto() {
        //Given
        Equipment equipment = createEquipment();
        //When
        EquipmentDto equipmentDto = equipmentMapper.mapToEquipmentDto(equipment);
        //Then
        assertNotNull(equipment);
        assertEquals(Long.valueOf(1), equipment.getId());
        assertEquals("test equipment", equipmentDto.getDescription());
    }

    @Test
    public void testMapToEquipmentDtoList() {
        //Given
        Equipment equipment = createEquipment();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipment);
        //When
        List<EquipmentDto> equipmentDtoList = equipmentMapper.mapToEquipmentDtoList(equipmentList);
        //Then
        assertNotNull(equipmentDtoList);
        assertEquals(1, equipmentDtoList.size());
    }
}
