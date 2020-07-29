package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String engineCapacity;
    private String engineType;
    @ManyToMany(mappedBy = "equipmentList")
    private List<Camper> camperList = new ArrayList();
}
