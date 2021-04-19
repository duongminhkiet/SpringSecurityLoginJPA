package com.zmk.security.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zmk.security.test.object.CustomeUserDetails;
import com.zmk.security.test.object.User;
import com.zmk.security.test.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username1) throws UsernameNotFoundException {
        User user = userRepository.findByUsername1(username1);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        //log.info("loadUserByUsername() : {}", username);

        return new CustomeUserDetails(user);
    }
}
