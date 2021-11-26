package com.app.ohmybooks.service;

import com.app.ohmybooks.entity.User;
import com.app.ohmybooks.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public User saveUser(final User user) {
        return userRepo.save(user);
    }
}
