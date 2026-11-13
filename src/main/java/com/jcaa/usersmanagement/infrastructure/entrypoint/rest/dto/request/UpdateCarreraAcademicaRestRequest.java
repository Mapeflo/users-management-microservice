package com.jcaa.usersmanagement.infrastructure.entrypoint.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateCarreraAcademicaRestRequest(
        @NotBlank @Size(min = 3) String nombre,
        @NotNull @Positive Integer numCreditos,
        @NotNull @Positive Integer numAsignaturas,
        @NotNull @Positive Integer numSemestres,
        @NotBlank String nivelFormacion,
        @NotBlank String titulo,
        @NotNull @Positive Double valorSemestre,
        @NotBlank String universidad,
        @NotNull Boolean esAcreditada,
        String perfiles,
        @NotBlank String areaConocimiento
) {}