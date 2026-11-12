package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCarreraAcademicaIdException;
import java.util.Objects;

public record CarreraAcademicaId(Long value) {

    public CarreraAcademicaId {
        Objects.requireNonNull(value, "CarreraAcademicaId cannot be null");
        if (value <= 0) {
            throw InvalidCarreraAcademicaIdException.becauseValueIsNotPositive();
        }
    }

    public static CarreraAcademicaId of(Long value) {
        return new CarreraAcademicaId(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
