package com.musicDB.service;

import com.musicDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private com.musicDB.entity.User userLogged;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userLogged = userRepository.findByUsername(username);
        UserBuilder builder = null;

        if (userLogged != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(userLogged.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
