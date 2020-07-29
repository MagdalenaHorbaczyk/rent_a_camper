package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS")
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue
    private Long id;
    private String logMessage;
}
