package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.domain.dto.FineDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FineMapper {

    public Fine mapToFine(final FineDto fineDto) {
        return new Fine(
                fineDto.getId(),
                fineDto.getDescription(),
                fineDto.getCharged(),
                fineDto.getBooking());
    }

    public FineDto mapToFineDto(final Fine fine) {
        return new FineDto.FineDtoBuilder()
                .id(fine.getId())
                .description(fine.getDescription())
                .charged(fine.getCharged())
                .booking(fine.getBooking())
                .build();
    }

    public List<FineDto> mapToFineDtoList(final List<Fine> fineList) {
        return fineList.stream()
                .map(t -> new FineDto(t.getId(), t.getDescription(), t.getCharged(), t.getBooking()))
                .collect(Collectors.toList());
    }
}
