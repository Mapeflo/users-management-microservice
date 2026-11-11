package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;

public interface GetCarreraAcademicaByIdUseCase {
    CarreraAcademicaModel getById(Long id);
}