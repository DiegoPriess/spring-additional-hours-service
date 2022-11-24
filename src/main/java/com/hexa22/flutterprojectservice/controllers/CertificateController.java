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
        service.save(Certificate.create()
                            .withUserCreator(userService.getDetails(certificate.getUserCreator()))
                            .withUserJudge(userService.getDetails(certificate.getUserJudge()))
                            .withAmountHours(certificate.getAmountHours())
                            .withDocument(certificate.getDocument())
                            .withDescription(certificate.getDescription())
                            .withStatus(certificate.getStatus()));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDetails(id));
    }

    @GetMapping("/details/{id}/{status}")
    public ResponseEntity getDetails(@PathVariable Long id, @PathVariable char status, @PathVariable Long userJudgerId) {
        service.judgeCertificate(id, status, userJudgerId);
        return ResponseEntity.ok().build();
    }
}

