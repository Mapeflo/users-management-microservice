package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetCarreraAcademicaByIdUseCase;
import com.jcaa.usersmanagement.application.port.out.GetCarreraAcademicaByIdPort;
import com.jcaa.usersmanagement.application.service.dto.query.GetCarreraAcademicaByIdQuery;
import com.jcaa.usersmanagement.application.service.mapper.CarreraAcademicaApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CarreraAcademicaNotFoundException;
import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;
import com.jcaa.usersmanagement.domain.valueobject.CarreraAcademicaId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetCarreraAcademicaByIdService implements GetCarreraAcademicaByIdUseCase {

    private final GetCarreraAcademicaByIdPort getCarreraAcademicaByIdPort;

    @Override
    public CarreraAcademicaModel getById(Long id) {
        final CarreraAcademicaId carreraId = CarreraAcademicaId.of(id);

        return getCarreraAcademicaByIdPort
                .findById(carreraId.value())
                .orElseThrow(() -> new CarreraAcademicaNotFoundException(
                        "No se encontró la carrera académica con ID: " + id));
    }
}