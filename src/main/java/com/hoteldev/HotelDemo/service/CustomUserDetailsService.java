package com.hoteldev.HotelDemo.service;

import com.hoteldev.HotelDemo.exception.ProjectException;
import com.hoteldev.HotelDemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ClassName: CustomUserDetailSerivce
 * Package: com.hoteldev.HotelDemo.service
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 2:55 pm
 * @Version 1.0
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new ProjectException("Error: Username/Email not found."));
    }
}
