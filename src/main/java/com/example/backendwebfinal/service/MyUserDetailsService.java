package com.example.backendwebfinal.service;


import com.example.backendwebfinal.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public interface MyUserDetailsService extends UserDetailsService {
    public void saveUser(User user);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
