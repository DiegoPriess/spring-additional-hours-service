package com.hexa22.flutterprojectservice.repository;

import com.hexa22.flutterprojectservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(@NotNull final String email, @NotNull final String password);
}