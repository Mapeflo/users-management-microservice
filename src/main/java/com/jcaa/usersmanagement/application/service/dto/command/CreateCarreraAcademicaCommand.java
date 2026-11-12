package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCarreraAcademicaCommand(
        @NotBlank(message = "nombre must not be blank")
        @Size(min = 3, message = "nombre must have at least 3 characters")
        String nombre,

        @NotNull(message = "numCreditos must not be null")
        @Positive(message = "numCreditos must be positive")
        Integer numCreditos,

        @NotNull(message = "numAsignaturas must not be null")
        @Positive(message = "numAsignaturas must be positive")
        Integer numAsignaturas,

        @NotNull(message = "numSemestres must not be null")
        @Positive(message = "numSemestres must be positive")
        Integer numSemestres,

        @NotBlank(message = "nivelFormacion must not be blank")
        String nivelFormacion,

        @NotBlank(message = "titulo must not be blank")
        String titulo,

        @NotNull(message = "valorSemestre must not be null")
        @Positive(message = "valorSemestre must be positive")
        Double valorSemestre,

        @NotBlank(message = "universidad must not be blank")
        String universidad,

        @NotNull(message = "esAcreditada must not be null")
        Boolean esAcreditada,

        String perfiles,

        @NotBlank(message = "areaConocimiento must not be blank")
        String areaConocimiento
) {
}