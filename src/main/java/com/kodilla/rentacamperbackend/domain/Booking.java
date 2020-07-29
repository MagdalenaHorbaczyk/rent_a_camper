package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "BOOKINGS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Camper camper;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private String paymentMethod;
    private BigDecimal cost;

    @OneToMany(
            targetEntity = Fine.class,
            mappedBy = "booking",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private List<Fine> fineList;
}
