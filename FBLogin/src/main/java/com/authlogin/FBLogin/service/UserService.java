package com.authlogin.FBLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authlogin.FBLogin.model.Provider;
import com.authlogin.FBLogin.model.User;
import com.authlogin.FBLogin.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
     
    public void processOAuthPostLogin(String username) {
    	System.out.println("username: " + username);
        User existUser = repo.getUserByUsername(username);
         
        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.FACEBOOK);
            newUser.setEnabled(true);          
             
            repo.save(newUser);        
        }
         
    }
}