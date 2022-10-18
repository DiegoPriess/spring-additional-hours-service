package com.hexa22.flutterprojectservice.controllers;

import com.hexa22.flutterprojectservice.models.Certificate;
import com.hexa22.flutterprojectservice.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    final CertificateService service;

    @Autowired
    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity create(@RequestBody @Valid Certificate certificate){
        service.save(certificate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Certificate> getDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDetails(id));
    }

    @GetMapping("/details/{id}/{status}")
    public ResponseEntity getDetails(@PathVariable Long id, @PathVariable char status, @PathVariable Long userJudgerId) {
        service.judgeCertificate(id, status, userJudgerId);
        return ResponseEntity.ok().build();
    }
}

