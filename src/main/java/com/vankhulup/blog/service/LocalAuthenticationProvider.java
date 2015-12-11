package com.vankhulup.blog.service;

import com.vankhulup.blog.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Vans on 25.08.2014.
 */
@Service
public class LocalAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserManagementService userService;

    @Autowired
    PasswordEncoder encoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        System.out.println();
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        String password = (String)usernamePasswordAuthenticationToken.getCredentials();

        if (!StringUtils.hasText(password)) {
            logger.warn("Username {}: no password provided", username);
            throw new BadCredentialsException("Please enter password");
        }

        User foundUser = userService.getUserByName(username);

        if (foundUser == null) {
            logger.warn("Username {}: no password provided", username);
            throw new UsernameNotFoundException("Invalid login");
        }

        if (!encoder.matches(password, foundUser.getPassword())){
            logger.warn("Password is incorrect!!");
            throw new BadCredentialsException("wrong password");
        }
        final List<GrantedAuthority> authorities;

        if (foundUser.getRole().compareTo(User.ROLES.ROLE_USER) == 0){
            authorities = AuthorityUtils.createAuthorityList(foundUser.getRole().toString());
        }else {
            authorities = AuthorityUtils.NO_AUTHORITIES;
        }
        return new org.springframework.security.core.userdetails.User(username, password,
                true,
                true,
                true,
                true,
                authorities);
    }
}
