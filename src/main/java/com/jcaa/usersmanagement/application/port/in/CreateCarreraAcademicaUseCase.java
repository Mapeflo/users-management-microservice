package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;

public interface CreateCarreraAcademicaUseCase {
    CarreraAcademicaModel create(CarreraAcademicaModel carrera);
}