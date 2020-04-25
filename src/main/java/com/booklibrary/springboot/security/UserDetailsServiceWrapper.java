package com.booklibrary.springboot.security;

import com.booklibrary.springboot.exception.NotFoundException;
import com.booklibrary.springboot.exception.ServiceErrorCode;
import com.booklibrary.springboot.model.UserModel;
import com.booklibrary.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceWrapper implements UserDetailsService {
    @Autowired
    private UserService userService;

//    @Autowired
//    public UserDetailsServiceWrapper(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try{
            UserModel user = userService.getUserByLogin(login);
            return new UserWrapper(user);
        }
        catch(UsernameNotFoundException e){
            throw new NotFoundException(
                    String.format("User with username=% not found", login)
                    , ServiceErrorCode.USER_NOT_FOUND);
        }

    }
}
