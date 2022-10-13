package com.hexa22.flutterprojectservice.repository;

import com.hexa22.flutterprojectservice.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}