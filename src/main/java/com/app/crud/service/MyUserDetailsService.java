package com.app.crud.service;

// code partially used from: https://github.com/koushikkothagal/spring-security-jpa

import com.app.crud.model.MyUserDetails;
import com.app.crud.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = new Users();
        user.setEmail(email);

        List<Users> user2 = usersService.findOne(user);

        if (user2.get(0) == null) {
            throw new UsernameNotFoundException("Not found: " + email);
        } else {
            return new MyUserDetails(user2.get(0));
        }
    }
}
