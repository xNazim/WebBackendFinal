//package com.example.backendwebfinal.service;
//
//import com.example.backendwebfinal.entity.User;
//import com.example.backendwebfinal.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        User user = userRepository.getUserByUsername(username);
//
//        if (user != null) {
//            return new MyUserDetails(user);
//        }
//        throw new UsernameNotFoundException("Could not find user");
//
//    }
//
//}