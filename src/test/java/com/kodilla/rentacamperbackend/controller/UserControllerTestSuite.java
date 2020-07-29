package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.UserStatus;
import com.kodilla.rentacamperbackend.domain.dto.UserDto;
import com.kodilla.rentacamperbackend.mapper.UserMapper;
import com.kodilla.rentacamperbackend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {

    @MockBean
    UserService userService;
    @MockBean
    UserMapper userMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetUsers() throws Exception {
        //Given
        List<User> userList = new ArrayList<>();
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        userList.add(user);
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto(1L, "Dto test login", "Dto test",
                "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        userDtoList.add(userDto);
        when(userService.findAllUsers()).thenReturn(userList);
        when(userMapper.mapToUserDtoList(userList)).thenReturn(userDtoList);
        //When & Then
        mockMvc.perform(get("/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].login", is("Dto test login")))
                .andExpect(jsonPath("$[0].password", is("Dto test")));
    }

    @Test
    public void testGetUser() throws Exception {
        //Given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        UserDto userDto = new UserDto(1L, "Dto test login", "Dto test",
                "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        when(userService.getUser(user.getId())).thenReturn(Optional.ofNullable(user));
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(userDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);
        //When & Then
        mockMvc.perform(get("/v1/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.login", is("Dto test login")))
                .andExpect(jsonPath("$.password", is("Dto test")));
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        //Given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        UserDto userDto = new UserDto(1L, "Dto test login", "Dto test",
                "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);
        when(userMapper.mapToUser(any(UserDto.class))).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);
        //When & Then
        mockMvc.perform(put("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.login", is("Dto test login")))
                .andExpect(jsonPath("$.password", is("Dto test")));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        //Given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        UserDto userDto = new UserDto(1L, "Dto test login", "Dto test",
                "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);
        when(userMapper.mapToUser(any(UserDto.class))).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);
        //When & Then
        mockMvc.perform(post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}

