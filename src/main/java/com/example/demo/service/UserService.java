package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsernamePassword(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user != null && password.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}
