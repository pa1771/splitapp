package com.fin.splitapp.service;

import com.fin.splitapp.config.CustomUserDetails;
import com.fin.splitapp.dto.UserDto;
import com.fin.splitapp.model.User;
import com.fin.splitapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(new UserDto(user.getUserId(), user.getUserName(), user.getPassword(), user.getMobile()));
    }
}
