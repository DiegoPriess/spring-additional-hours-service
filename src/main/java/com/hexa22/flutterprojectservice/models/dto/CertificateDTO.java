package com.hexa22.flutterprojectservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {

    @NotNull
    private Long id;

    @NotNull
    private Long userCreator;

    @NotNull
    private Long userJudge;

    @NotNull
    private LocalTime amountHours;

    @NotNull
    private String document;

    @NotNull
    private String description;

    @NotNull
    private char status;
}
