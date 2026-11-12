package com.jcaa.usersmanagement.domain.event;

import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;
import java.util.Map;
import lombok.Getter;

@Getter
public final class CarreraAcademicaCreatedDomainEvent extends DomainEvent {

    private static final String EVENT_NAME = "carrera.academica.created";

    private final CarreraAcademicaModel carrera;

    public CarreraAcademicaCreatedDomainEvent(final CarreraAcademicaModel carrera) {
        super(EVENT_NAME);
        this.carrera = carrera;
    }

    @Override
    public Map<String, String> payload() {
        return Map.of(
                "id", carrera.getId() != null ? carrera.getId().toString() : "null",
                "nombre", carrera.getNombre().value(),
                "nivelFormacion", carrera.getNivelFormacion().name(),
                "universidad", carrera.getUniversidad()
        );
    }
}