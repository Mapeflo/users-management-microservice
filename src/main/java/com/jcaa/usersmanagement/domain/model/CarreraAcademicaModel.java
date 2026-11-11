package com.jcaa.usersmanagement.domain.model;

import lombok.Value;

@Value
public class CarreraAcademicaModel {

    Long id;
    String nombre;
    Integer numCreditos;
    Integer numAsignaturas;
    Integer numSemestres;
    String nivelFormacion;
    String titulo;
    Double valorSemestre;
    String universidad;
    Boolean esAcreditada;
    String perfiles;
    String areaConocimiento;

    public static CarreraAcademicaModel create(
            final String nombre,
            final Integer numCreditos,
            final Integer numAsignaturas,
            final Integer numSemestres,
            final String nivelFormacion,
            final String titulo,
            final Double valorSemestre,
            final String universidad,
            final Boolean esAcreditada,
            final String perfiles,
            final String areaConocimiento) {

        return new CarreraAcademicaModel(
                null,
                nombre,
                numCreditos,
                numAsignaturas,
                numSemestres,
                nivelFormacion,
                titulo,
                valorSemestre,
                universidad,
                esAcreditada,
                perfiles,
                areaConocimiento
        );
    }
}