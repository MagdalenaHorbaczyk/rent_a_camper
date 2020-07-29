package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.dto.UserDto;
import com.kodilla.rentacamperbackend.exception.UserNotFoundException;
import com.kodilla.rentacamperbackend.mapper.UserMapper;
import com.kodilla.rentacamperbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.findAllUsers());
    }

    @GetMapping(value = "/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
