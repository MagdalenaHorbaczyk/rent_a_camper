package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getBookingList(),
                userDto.getStatus());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto.UserDtoBuilder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .bookingList(user.getBookingList())
                .status(user.getStatus())
                .build();
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getLogin(), t.getPassword(), t.getEmail(), t.getFirstname(), t.getLastname(),
                        t.getBookingList(), t.getStatus()))
                .collect(Collectors.toList());
    }
}
