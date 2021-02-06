package com.udemy.service.impl;

import java.util.List;
import java.util.Set;

import com.udemy.entity.User;
import com.udemy.entity.UserRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    private User buildUser(User user, List<GrantedAuthority> authorities) {
        return null;
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole) {
        return null;
    }
    
}
