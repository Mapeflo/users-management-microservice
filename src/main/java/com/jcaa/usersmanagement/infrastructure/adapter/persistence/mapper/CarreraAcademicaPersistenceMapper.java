package com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper;

import com.jcaa.usersmanagement.domain.enums.NivelFormacion;
import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaId;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaNombre;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto.CarreraAcademicaPersistenceDto;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.CarreraAcademicaEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarreraAcademicaPersistenceMapper {

    public CarreraAcademicaPersistenceDto fromModelToDto(final CarreraAcademicaModel carrera) {
        return new CarreraAcademicaPersistenceDto(
                carrera.getId() != null ? carrera.getId().value() : null,
                carrera.getNombre().value(),
                carrera.getNumCreditos(),
                carrera.getNumAsignaturas(),
                carrera.getNumSemestres(),
                carrera.getNivelFormacion().name(),
                carrera.getTitulo(),
                carrera.getValorSemestre(),
                carrera.getUniversidad(),
                carrera.getEsAcreditada(),
                carrera.getPerfiles(),
                carrera.getAreaConocimiento(),
                null
        );
    }

    public CarreraAcademicaEntity fromResultSetToEntity(final ResultSet resultSet) throws SQLException {
        return new CarreraAcademicaEntity(
                resultSet.getLong("id"),
                resultSet.getString("nombre"),
                resultSet.getInt("num_creditos"),
                resultSet.getInt("num_asignaturas"),
                resultSet.getInt("num_semestres"),
                resultSet.getString("nivel_formacion"),
                resultSet.getString("titulo"),
                resultSet.getDouble("valor_semestre"),
                resultSet.getString("universidad"),
                resultSet.getBoolean("es_acreditada"),
                resultSet.getString("perfiles"),
                resultSet.getString("area_conocimiento"),
                resultSet.getString("created_at")
        );
    }

    public CarreraAcademicaModel fromEntityToModel(final CarreraAcademicaEntity entity) {
        return new CarreraAcademicaModel(
                entity.id() != null ? CarreraAcademicaId.of(entity.id()) : null,
                new CarreraAcademicaNombre(entity.nombre()),
                entity.numCreditos(),
                entity.numAsignaturas(),
                entity.numSemestres(),
                NivelFormacion.valueOf(entity.nivelFormacion()),
                entity.titulo(),
                entity.valorSemestre(),
                entity.universidad(),
                entity.esAcreditada(),
                entity.perfiles(),
                entity.areaConocimiento()
        );
    }

    public CarreraAcademicaModel fromResultSetToModel(final ResultSet resultSet) throws SQLException {
        return fromEntityToModel(fromResultSetToEntity(resultSet));
    }

    public List<CarreraAcademicaModel> fromResultSetToModelList(final ResultSet resultSet) throws SQLException {
        final List<CarreraAcademicaModel> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(fromResultSetToModel(resultSet));
        }
        return list;
    }
}