package com.hexa22.flutterprojectservice.repository;

import com.hexa22.flutterprojectservice.models.Certificate;
import com.hexa22.flutterprojectservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    List<Certificate> findByUserCreator(@NotNull User user);
}