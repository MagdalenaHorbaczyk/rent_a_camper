package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.User;
import com.kodilla.rentacamperbackend.domain.UserStatus;
import com.kodilla.rentacamperbackend.domain.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class
UserMapperTestSuite {
    @Autowired
    private UserMapper userMapper;

    private User createUser() {
        return new User(1L, "test login", "test", "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
    }

    private UserDto createUserDto() {
        return new UserDto(1L, "Dto test login", "Dto test",
                "jaranowski@gmail.com", "John",
                "Aranovsky", new ArrayList<>(), UserStatus.ACTIVE);
    }

    @Test
    public void testMapToUser() {
        //Given
        UserDto userDto = createUserDto();
        //When
        User user = userMapper.mapToUser(userDto);
        //Then
        assertNotNull(user);
        assertEquals(Long.valueOf(1), user.getId());
        assertEquals("Dto test login", user.getLogin());
    }

    @Test
    public void testMapToUserDto() {
        //Given
        User user = createUser();
        //When
        UserDto userDto = userMapper.mapToUserDto(user);
        //Then
        assertNotNull(user);
        assertEquals(Long.valueOf(1), user.getId());
        assertEquals("test login", userDto.getLogin());
    }

    @Test
    public void testMapToUserDtoList() {
        //Given
        User user = createUser();
        List<User> userList = new ArrayList<>();
        userList.add(user);
        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userList);
        //Then
        assertNotNull(userDtoList);
        assertEquals(1, userDtoList.size());
    }
}
