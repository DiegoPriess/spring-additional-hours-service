package com.hexa22.flutterprojectservice.controllers;

import com.hexa22.flutterprojectservice.models.Certificate;
import com.hexa22.flutterprojectservice.models.dto.CertificateDTO;
import com.hexa22.flutterprojectservice.services.CertificateService;
import com.hexa22.flutterprojectservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    final CertificateService service;

    final UserService userService;

    @Autowired
    public CertificateController(CertificateService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CertificateDTO certificate){
        service.save(certificate);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/details/{id}/{status}")
    public ResponseEntity judgeCertificate(@PathVariable Long id, @PathVariable char status, @PathVariable Long userJudgerId) {
        service.judgeCertificate(id, status, userJudgerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Certificate> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

