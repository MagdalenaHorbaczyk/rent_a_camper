package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.UserStatus;
import com.kodilla.rentacamperbackend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestSuite {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;

    @Test
    public void getAllUsersTest() {
        //when
        userService.findAllUsers();
        //then
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void getUserTest() {
        //given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        //when
        userService.getUser(user.getId());
        //then
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void saveUserTest() {
        //given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        //when
        userService.saveUser(user);
        //then
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void deleteUserTest() {
        //given
        User user = new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
        //when
        userService.deleteUser(user.getId());
        //then
        verify(userRepository, times(1)).deleteById(1L);
    }
}
