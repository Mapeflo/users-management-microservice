package com.jcaa.usersmanagement.domain.exception;

public class InvalidCarreraAcademicaIdException extends DomainException {

    private InvalidCarreraAcademicaIdException(String message) {
        super(message);
    }

    public static InvalidCarreraAcademicaIdException becauseValueIsNull() {
        return new InvalidCarreraAcademicaIdException("El ID de la carrera académica no puede ser nulo");
    }

    public static InvalidCarreraAcademicaIdException becauseValueIsNotPositive() {
        return new InvalidCarreraAcademicaIdException("El ID de la carrera académica debe ser un número positivo");
    }
}