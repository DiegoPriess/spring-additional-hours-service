package com.hexa22.flutterprojectservice.services;

import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getById(@NotNull final Long id) {
        return repository.findById(id).get();
    }

    public void save(@NotNull final User user) {
        if(!(user.getId() == null)){
            Assert.notNull(repository.findById(user.getId()), "Usuário não encontrado");
        }

        repository.save(user);
    }

    public User authenticate(@NotNull final String email, @NotNull final String password) {
        User userFound = repository.findByEmailAndPassword(email, password);
        Assert.notNull(userFound, "Usuário ou senha incorreta");
        return userFound;
    }
}

