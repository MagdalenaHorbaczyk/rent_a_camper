package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.dto.CamperDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CamperMapper {

    public Camper mapToCamper(final CamperDto camperDto) {
        return new Camper(
                camperDto.getId(),
                camperDto.getSeatsQuantity(),
                camperDto.getBedsQuantity(),
                camperDto.getDailyRentPrice(),
                camperDto.getEquipmentList(),
                camperDto.getCategory(),
                camperDto.getBookingList());
    }

    public CamperDto mapToCamperDto(final Camper camper) {
        return new CamperDto.CamperDtoBuilder()
                .id(camper.getId())
                .seatsQuantity(camper.getSeatsQuantity())
                .bedsQuantity(camper.getBedsQuantity())
                .dailyRentPrice(camper.getDailyRentPrice())
                .equipmentList(camper.getEquipmentList())
                .category(camper.getCategory())
                .bookingList(camper.getBookingList())
                .build();
    }

    public List<CamperDto> mapToCamperDtoList(final List<Camper> camperList) {
        return camperList.stream()
                .map(t -> new CamperDto(t.getId(), t.getSeatsQuantity(), t.getBedsQuantity(), t.getDailyRentPrice(),
                        t.getEquipmentList(), t.getCategory(), t.getBookingList()))
                .collect(Collectors.toList());
    }
}
