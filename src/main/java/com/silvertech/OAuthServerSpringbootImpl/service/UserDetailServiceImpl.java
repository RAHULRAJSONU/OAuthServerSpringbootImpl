package com.silvertech.OAuthServerSpringbootImpl.service;

import com.silvertech.OAuthServerSpringbootImpl.model.AuthUserDetail;
import com.silvertech.OAuthServerSpringbootImpl.model.User;
import com.silvertech.OAuthServerSpringbootImpl.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepository.findByUsername(username);
        optionalUser.orElseThrow(()->new UsernameNotFoundException("Username or password wrong"));
        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
