package com.jcaa.usersmanagement.domain.event;

import java.util.Map;
import lombok.Getter;

@Getter
public final class CarreraAcademicaDeletedDomainEvent extends DomainEvent {

    private static final String EVENT_NAME = "carrera.academica.deleted";

    private final Long carreraId;

    public CarreraAcademicaDeletedDomainEvent(final Long carreraId) {
        super(EVENT_NAME);
        this.carreraId = carreraId;
    }

    @Override
    public Map<String, String> payload() {
        return Map.of(
                "id", String.valueOf(carreraId)
        );
    }
}