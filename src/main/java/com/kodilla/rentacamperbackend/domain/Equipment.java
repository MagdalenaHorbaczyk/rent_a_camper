package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EQUIPMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipment {
    @Id
    @GeneratedValue
    @Column(name = "EQUIPMENT_ID")
    private Long id;
    private String description;
    private boolean bedSet;
    private boolean towelSet;
    private boolean bikeRack;
    private boolean childSeat;
    private boolean kitchenKit;
    private boolean snowChains;
    private boolean winterTire;

    @ManyToMany(mappedBy = "equipmentList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Camper> camperList = new ArrayList<Camper>();
}
