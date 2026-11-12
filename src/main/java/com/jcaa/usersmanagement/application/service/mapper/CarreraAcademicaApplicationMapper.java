package com.jcaa.usersmanagement.application.service.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreateCarreraAcademicaCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteCarreraAcademicaCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCarreraAcademicaCommand;
import com.jcaa.usersmanagement.application.service.dto.query.GetCarreraAcademicaByIdQuery;
import com.jcaa.usersmanagement.domain.enums.NivelFormacion;
import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaId;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaNombre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarreraAcademicaApplicationMapper {

    public CarreraAcademicaModel fromCreateCommandToModel(final CreateCarreraAcademicaCommand command) {
        return CarreraAcademicaModel.create(
                new CarreraAcademicaNombre(command.nombre()),
                command.numCreditos(),
                command.numAsignaturas(),
                command.numSemestres(),
                NivelFormacion.valueOf(command.nivelFormacion().toUpperCase()),
                command.titulo(),
                command.valorSemestre(),
                command.universidad(),
                command.esAcreditada(),
                command.perfiles(),
                command.areaConocimiento()
        );
    }

    public CarreraAcademicaModel fromUpdateCommandToModel(final UpdateCarreraAcademicaCommand command) {
        return new CarreraAcademicaModel(
                CarreraAcademicaId.of(command.id()),
                new CarreraAcademicaNombre(command.nombre()),
                command.numCreditos(),
                command.numAsignaturas(),
                command.numSemestres(),
                NivelFormacion.valueOf(command.nivelFormacion().toUpperCase()),
                command.titulo(),
                command.valorSemestre(),
                command.universidad(),
                command.esAcreditada(),
                command.perfiles(),
                command.areaConocimiento()
        );
    }

    public CarreraAcademicaId fromGetByIdQueryToId(final GetCarreraAcademicaByIdQuery query) {
        return CarreraAcademicaId.of(query.id());
    }

    public CarreraAcademicaId fromDeleteCommandToId(final DeleteCarreraAcademicaCommand command) {
        return CarreraAcademicaId.of(command.id());
    }
}