package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAMPERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Camper {
    @Id
    @GeneratedValue
    @Column(name = "CAMPER_ID")
    private Long id;
    private int seatsQuantity;
    private int bedsQuantity;
    private BigDecimal dailyRentPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CAMPER_EQUIPMENT",
            joinColumns = {@JoinColumn(name = "CAMPER_ID", referencedColumnName = "CAMPER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "EQUIPMENT_ID")}
    )
    private List<Equipment> equipmentList = new ArrayList<Equipment>();

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(
            targetEntity = Booking.class,
            mappedBy = "camper",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    List<Booking> bookingList = new ArrayList<>();
}
