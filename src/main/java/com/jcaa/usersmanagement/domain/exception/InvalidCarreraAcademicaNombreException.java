package com.jcaa.usersmanagement.domain.exception;

public class InvalidCarreraAcademicaNombreException extends DomainException {

    private InvalidCarreraAcademicaNombreException(String message) {
        super(message);
    }

    public static InvalidCarreraAcademicaNombreException becauseValueIsEmpty() {
        return new InvalidCarreraAcademicaNombreException("El nombre de la carrera académica no puede estar vacío");
    }

    public static InvalidCarreraAcademicaNombreException becauseLengthIsTooShort(int minimumLength) {
        return new InvalidCarreraAcademicaNombreException(
                "El nombre de la carrera académica debe tener al menos " + minimumLength + " caracteres");
    }
}