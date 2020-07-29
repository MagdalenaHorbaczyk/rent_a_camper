package com.kodilla.rentacamperbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstname;
    private String lastname;

    @OneToMany(
            targetEntity = Booking.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Booking> bookingList;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
