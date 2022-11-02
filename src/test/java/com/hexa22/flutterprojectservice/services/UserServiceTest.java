package com.hexa22.flutterprojectservice.services;

import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkAuthenticateUserWhenEmailAndPasswordCorrect() {
        final User user = User.create().withName("teste")
                                       .withRegistrationNumber("123123")
                                       .withEmail("teste@gmail.com")
                                       .withPassword("teste123")
                                       .withPermission('1');

        userRepository.save(user);

        User authenticatedUser = userRepository.findByEmailAndPassword("teste@gmail.com", "teste123");
        assertNotNull(authenticatedUser, "Erro na autenticacao de usuario, nao esta achando um usuario cadastrado");
    }

    @Test
    public void checkAuthenticateUserWhenEmailWrong() {
        final User user = User.create().withName("teste")
                                       .withRegistrationNumber("123123")
                                       .withEmail("teste@gmail.com")
                                       .withPassword("teste123")
                                       .withPermission('1');

        userRepository.save(user);

        User authenticatedUser = userRepository.findByEmailAndPassword("diego@gmail.com", "teste123");
        assertNull(authenticatedUser, "Erro na autenticacao de usuario, achou um usuario mesmo colocando o email errado");
    }

    @Test
    public void checkAuthenticateUserWhenPasswordWrong() {
        final User user = User.create().withName("teste")
                                       .withRegistrationNumber("123123")
                                       .withEmail("teste@gmail.com")
                                       .withPassword("teste123")
                                       .withPermission('1');

        userRepository.save(user);

        User authenticatedUser = userRepository.findByEmailAndPassword("teste@gmail.com", "teste12332323");
        assertNull(authenticatedUser, "Erro na autenticacao de usuario, achou um usuario mesmo colocando a senha errada");
    }

}