package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Equipment;
import com.kodilla.rentacamperbackend.domain.dto.EquipmentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipmentMapper {

    public Equipment mapToEquipment(final EquipmentDto equipmentDto) {
        return new Equipment(
                equipmentDto.getId(),
                equipmentDto.getDescription(),
                equipmentDto.isBedSet(),
                equipmentDto.isTowelSet(),
                equipmentDto.isBikeRack(),
                equipmentDto.isChildSeat(),
                equipmentDto.isKitchenKit(),
                equipmentDto.isSnowChains(),
                equipmentDto.isWinterTire(),
                equipmentDto.getCamperList());
    }

    public EquipmentDto mapToEquipmentDto(final Equipment equipment) {
        return new EquipmentDto.EquipmentDtoBuilder()
                .id(equipment.getId())
                .description(equipment.getDescription())
                .bedSet(equipment.isBedSet())
                .towelSet(equipment.isTowelSet())
                .bikeRack(equipment.isBikeRack())
                .childSeat(equipment.isChildSeat())
                .kitchenKit(equipment.isKitchenKit())
                .snowChains(equipment.isSnowChains())
                .winterTire(equipment.isWinterTire())
                .camperList(equipment.getCamperList())
                .build();
    }

    public List<EquipmentDto> mapToEquipmentDtoList(final List<Equipment> equipmentList) {
        return equipmentList.stream()
                .map(t -> new EquipmentDto(t.getId(), t.getDescription(), t.isBedSet(), t.isTowelSet(),
                        t.isBikeRack(), t.isChildSeat(), t.isKitchenKit(), t.isSnowChains(), t.isWinterTire(),
                        t.getCamperList()))
                .collect(Collectors.toList());
    }
}
