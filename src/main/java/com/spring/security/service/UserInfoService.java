package com.spring.security.service;

import com.spring.security.entity.UserInfo;
import com.spring.security.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail=repository.findByName(username);
        return userDetail.map(UserInfoDetails::new).
                orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
    public String addUser(UserInfo userInfo)throws Exception{

    }
}
