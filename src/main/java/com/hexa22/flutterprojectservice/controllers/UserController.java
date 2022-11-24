package com.hexa22.flutterprojectservice.controllers;

import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user){
        service.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/auth/{email}/{password}")
    public ResponseEntity<User> authenticate(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(service.authenticate(email, password));
    }
}
