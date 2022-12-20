package com.hamon.userms.services;

import com.hamon.userms.models.entities.User;
import com.hamon.userms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void cadastrar(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.getReferenceById(id);
    }
}
