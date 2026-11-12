package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.NivelFormacion;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaId;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaNombre;
import lombok.Value;

@Value
public class CarreraAcademicaModel {

    CarreraAcademicaId id;
    CarreraAcademicaNombre nombre;
    Integer numCreditos;
    Integer numAsignaturas;
    Integer numSemestres;
    NivelFormacion nivelFormacion;
    String titulo;
    Double valorSemestre;
    String universidad;
    Boolean esAcreditada;
    String perfiles;
    String areaConocimiento;

    public static CarreraAcademicaModel create(
            final CarreraAcademicaNombre nombre,
            final Integer numCreditos,
            final Integer numAsignaturas,
            final Integer numSemestres,
            final NivelFormacion nivelFormacion,
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