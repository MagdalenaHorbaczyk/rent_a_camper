package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FineDto {
    private Long id;
    private String description;
    private BigDecimal charged;
    private Booking booking;

    public static class FineDtoBuilder {
        private Long id;
        private String description;
        private BigDecimal charged;
        private Booking booking;

        public FineDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FineDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FineDtoBuilder charged(BigDecimal charged) {
            this.charged = charged;
            return this;
        }

        public FineDtoBuilder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public FineDto build() {
            return new FineDto(id, description, charged, booking);
        }
    }
}
