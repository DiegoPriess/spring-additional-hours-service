package com.hexa22.flutterprojectservice.controllers;

import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody User user){
        service.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDetails(id));
    }

    @GetMapping("/auth/{email}/{password}")
    public ResponseEntity<?> authenticate(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(service.authenticate(email, password));
    }
}
