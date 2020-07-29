package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FINES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fine {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    public BigDecimal charged;
    @ManyToOne
    private Booking booking;
}
