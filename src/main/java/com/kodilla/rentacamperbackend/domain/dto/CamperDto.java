package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CamperDto {

    private Long id;
    private int seatsQuantity;
    private int bedsQuantity;
    private BigDecimal dailyRentPrice;
    private List<Equipment> equipmentList;
    private Category category;
    List<Booking> bookingList;

    public static class CamperDtoBuilder {

        private Long id;
        private int seatsQuantity;
        private int bedsQuantity;
        private BigDecimal dailyRentPrice;
        private List<Equipment> equipmentList;
        private Category category;
        List<Booking> bookingList;

        public CamperDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CamperDtoBuilder seatsQuantity(int seatsQuantity) {
            this.seatsQuantity = seatsQuantity;
            return this;
        }

        public CamperDtoBuilder bedsQuantity(int bedsQuantity) {
            this.bedsQuantity = bedsQuantity;
            return this;
        }

        public CamperDtoBuilder dailyRentPrice(BigDecimal dailyRentPrice) {
            this.dailyRentPrice = dailyRentPrice;
            return this;
        }

        public CamperDtoBuilder equipmentList(List<Equipment> equipmentList) {
            this.equipmentList = equipmentList;
            return this;
        }

        public CamperDtoBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public CamperDtoBuilder bookingList(List<Booking> bookingList) {
            this.bookingList = bookingList;
            return this;
        }

        public CamperDto build() {
            return new CamperDto(id, seatsQuantity, bedsQuantity, dailyRentPrice, equipmentList, category, bookingList);
        }
    }
}
