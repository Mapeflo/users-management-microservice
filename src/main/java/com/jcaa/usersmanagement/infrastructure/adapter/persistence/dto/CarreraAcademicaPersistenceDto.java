package com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto;

public record CarreraAcademicaPersistenceDto(
        Long id,
        String nombre,
        Integer numCreditos,
        Integer numAsignaturas,
        Integer numSemestres,
        String nivelFormacion,
        String titulo,
        Double valorSemestre,
        String universidad,
        Boolean esAcreditada,
        String perfiles,
        String areaConocimiento,
        String createdAt
) {}