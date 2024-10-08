package com.fin.splitapp.service;

import com.fin.splitapp.dto.UserDto;
import com.fin.splitapp.model.User;
import com.fin.splitapp.repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
public class TestUserService {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtService jwtService;

    @Mock
    AuthenticationManager authenticationManager;

    @InjectMocks
    UserService userService;

    @Test
    public void testRegisterUser() {
        UserDto userDto = new UserDto();
        userDto.setUserName("ravi");
        userDto.setPassword("123");
        userDto.setMobile("9123456789");
        when(passwordEncoder.encode("123")).thenReturn("321");
        User user = new User();
        when(userRepository.save(ArgumentMatchers.any())).thenReturn(user);
        assertAll(() -> userService.registerUser(userDto));
    }

    @Test
    public void testLoginUser() {
        UserDto userDto = new UserDto();
        userDto.setUserName("ravi");
        userDto.setPassword("123");
        userDto.setMobile("9123456789");
        Authentication authentication = mock();
        when(authenticationManager.authenticate(ArgumentMatchers.any())).thenReturn(authentication);
        when(authentication.isAuthenticated()).thenReturn(true);
        when(jwtService.generateToken(ArgumentMatchers.any(String.class))).thenReturn("abcd");
        String result = userService.loginUser(userDto);
        Assertions.assertThat(result).isEqualTo("abcd");
    }

}
