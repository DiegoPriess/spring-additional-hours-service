package com.hexa22.flutterprojectservice.services;

import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getDetails(@NotNull final Long id) {
        return repository.findById(id).get();
    }

    public void save(@NotNull final User user) {
        repository.save(user);
    }

    public User authenticate(@NotNull final String email, @NotNull final String password) {
        User userFound = repository.findByEmailAndPassword(email, password);
        Assert.notNull(userFound, "Usuário ou senha incorreta");
        return userFound;
    }
}

