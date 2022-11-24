package com.hexa22.flutterprojectservice.services;

import com.hexa22.flutterprojectservice.models.Certificate;
import com.hexa22.flutterprojectservice.models.User;
import com.hexa22.flutterprojectservice.models.dto.CertificateDTO;
import com.hexa22.flutterprojectservice.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    private final UserService userService;

    @Autowired
    public CertificateService(CertificateRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Certificate getById(@NotNull final Long id) {
        return repository.findById(id).get();
    }

    public void save(@NotNull final CertificateDTO certificate) {
        repository.save(Certificate.create()
                                    .withUserCreator(userService.getById(certificate.getUserCreator()))
                                    .withUserJudge(userService.getById(certificate.getUserJudge()))
                                    .withAmountHours(certificate.getAmountHours())
                                    .withDocument(certificate.getDocument())
                                    .withDescription(certificate.getDescription())
                                    .withStatus(certificate.getStatus()));
    }

    public void judgeCertificate(@NotNull final Long id, @NotNull final char status, @NotNull final Long userJudgerId) {
        final User userJudger = userService.getById(userJudgerId);
        Assert.notNull(userJudger, "Usuário julgador não encontrado");
        repository.save(repository.findById(id).get()
                                               .withStatus(status));
    }

    public void deleteById(@NotNull final Long id) {
        repository.deleteById(id);
    }
}

