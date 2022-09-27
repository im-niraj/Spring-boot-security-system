package com.spring.sprintbootsecuritylearn.services;

import com.spring.sprintbootsecuritylearn.Repository.UserRepository;
import com.spring.sprintbootsecuritylearn.models.CustomUserDetail;
import com.spring.sprintbootsecuritylearn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user==null) {
            throw new UsernameNotFoundException("No USER");
        }
        return new CustomUserDetail(user);
    }
}
