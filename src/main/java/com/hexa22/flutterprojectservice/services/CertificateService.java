package com.hexa22.flutterprojectservice.services;

import com.hexa22.flutterprojectservice.models.Certificate;
import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.repository.CertificateRepository;
import com.hexa22.flutterprojectservice.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    private final UserService userService;

    @Autowired
    public CertificateService(CertificateRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Certificate getDetails(@NotNull final Long id) {
        return repository.findById(id).get();
    }

    public void save(@NotNull final Certificate certificate) {
        repository.save(certificate);
    }

    public void judgeCertificate(@NotNull final Long id, @NotNull final char status, @NotNull final Long userJudgerId) {
        final User userJudger = userService.getDetails(userJudgerId);
        Assert.notNull(userJudger, "Usuário julgador não encontrado");
        repository.save(repository.findById(id).get()
                                               .withStatus(status));
    }
}

