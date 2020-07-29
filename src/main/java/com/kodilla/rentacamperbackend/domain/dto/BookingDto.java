package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.Fine;
import com.kodilla.rentacamperbackend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {
    private Long id;
    private User user;
    private Camper camper;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private String paymentMethod;
    private BigDecimal cost;
    private List<Fine> fineList;

    public static class BookingDtoBuilder {
        private Long id;
        private User user;
        private Camper camper;
        private LocalDate pickUpDate;
        private LocalDate dropOffDate;
        private String paymentMethod;
        private BigDecimal cost;
        private List<Fine> fineList;

        public BookingDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BookingDtoBuilder user(User user) {
            this.user = user;
            return this;
        }

        public BookingDtoBuilder camper(Camper camper) {
            this.camper = camper;
            return this;
        }

        public BookingDtoBuilder pickUpDate(LocalDate pickUpDate) {
            this.pickUpDate = pickUpDate;
            return this;
        }

        public BookingDtoBuilder dropOffDate(LocalDate dropOffDate) {
            this.dropOffDate = dropOffDate;
            return this;
        }

        public BookingDtoBuilder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public BookingDtoBuilder cost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public BookingDtoBuilder fineList(List<Fine> fineList) {
            this.fineList = fineList;
            return this;
        }

        public BookingDto build() {
            return new BookingDto(id, user, camper, pickUpDate, dropOffDate, paymentMethod, cost, fineList);
        }
    }
}
