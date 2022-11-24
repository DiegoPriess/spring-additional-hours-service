package com.hexa22.flutterprojectservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    private static final long serialVersionUID = 1L;

    public static synchronized User create() {
        return new User();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="registration_number")
    private String registrationNumber;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="cpf")
    private String cpf;

    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="permission")
    private char permission;

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password){
        this.password = password;
        return this;
    }

    public User withPermission(char permission) {
        this.permission = permission;
        return this;
    }
}
