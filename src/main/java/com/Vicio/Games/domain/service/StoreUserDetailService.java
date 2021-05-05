package com.Vicio.Games.domain.service;

import com.Vicio.Games.domain.dto.NewUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class StoreUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        NewUserDto user = userService.getByEmail(username);


        return new User(user.getEmail(), "{noop}" + user.getPassword(), new ArrayList<>());
    }

}
