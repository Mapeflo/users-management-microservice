package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidCarreraAcademicaNombreException;
import java.util.Objects;

public record CarreraAcademicaNombre(String value) {

    private static final int MINIMUM_LENGTH = 3;

    public CarreraAcademicaNombre {
        final String normalizedValue = Objects.requireNonNull(value, "CarreraAcademicaNombre cannot be null").trim();
        validateNotEmpty(normalizedValue);
        validateMinimumLength(normalizedValue);
        value = normalizedValue;
    }

    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidCarreraAcademicaNombreException.becauseValueIsEmpty();
        }
    }

    private static void validateMinimumLength(final String normalizedValue) {
        if (normalizedValue.length() < MINIMUM_LENGTH) {
            throw InvalidCarreraAcademicaNombreException.becauseLengthIsTooShort(MINIMUM_LENGTH);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}