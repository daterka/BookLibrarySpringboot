package com.booklibrary.springboot.service;

import com.booklibrary.springboot.exception.ConflictException;
import com.booklibrary.springboot.exception.NotFoundException;
import com.booklibrary.springboot.exception.ServiceErrorCode;
import com.booklibrary.springboot.model.Role;
import com.booklibrary.springboot.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    HashMap<String, UserModel> usersMap;

    public UserService() {
        this.usersMap = new HashMap<String, UserModel>();
        this.usersMap.put("admin", new UserModel(0, "admin", "admin", Role.ADMIN));
        for(int i = 1; i < 10; i++){
            this.usersMap.put("aaaa", new UserModel(i, "aaaa", "aaaa", Role.USER));
        }
    }

    public UserModel getUserByLogin(String login){
        if(usersMap.containsKey(login)){
            return usersMap.get(login);
        }
        else{
            throw new NotFoundException(String.format("User with login=%s not found", login), ServiceErrorCode.USER_NOT_FOUND);
        }
    }

    public void saveUser(String login, String password){
        try {
            if (this.usersMap.containsKey(login)) {
                throw new ConflictException(
                        String.format("Can not register new user, login+%s already exists in database.", login),
                        ServiceErrorCode.USER_ALREADY_EXISTED);
            }
//            Assuming we can register only a normal users
            final int[] new_user_id = {0};
            this.usersMap.forEach((k, v) -> {
                if (v.getId() > new_user_id[0]) {
                    new_user_id[0] = v.getId();
                }
            });

            UserModel new_user = new UserModel(new_user_id[0], login, password, Role.USER);
            this.usersMap.put(login, new_user);
        } finally { }

    }
}
