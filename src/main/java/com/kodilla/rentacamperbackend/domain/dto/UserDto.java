package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Booking;
import com.kodilla.rentacamperbackend.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private List<Booking> bookingList;
    private UserStatus status;

    public static class UserDtoBuilder {
        private Long id;
        private String login;
        private String password;
        private String email;
        private String firstname;
        private String lastname;
        private List<Booking> bookingList = new ArrayList<>();
        private UserStatus status;

        public UserDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserDtoBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserDtoBuilder bookingList(List<Booking> bookingList) {
            this.bookingList = bookingList;
            return this;
        }

        public UserDtoBuilder status(UserStatus status) {
            this.status = status;
            return this;
        }

        public UserDto build() {
            return new UserDto(id, login, password, email, firstname, lastname, bookingList, status);
        }
    }
}
