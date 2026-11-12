package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdateCarreraAcademicaUseCase;
import com.jcaa.usersmanagement.application.port.out.GetCarreraAcademicaByIdPort;
import com.jcaa.usersmanagement.application.port.out.UpdateCarreraAcademicaPort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateCarreraAcademicaCommand;
import com.jcaa.usersmanagement.application.service.mapper.CarreraAcademicaApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.CarreraAcademicaNotFoundException;
import com.jcaa.usersmanagement.domain.model.CarreraAcademicaModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateCarreraAcademicaService implements UpdateCarreraAcademicaUseCase {

    private final UpdateCarreraAcademicaPort updateCarreraAcademicaPort;
    private final GetCarreraAcademicaByIdPort getCarreraAcademicaByIdPort;
    private final Validator validator;

    @Override
    public CarreraAcademicaModel execute(final UpdateCarreraAcademicaCommand command) {
        validateCommand(command);

        // Verificar que existe
        getCarreraAcademicaByIdPort
                .findById(command.id())
                .orElseThrow(() -> new CarreraAcademicaNotFoundException(
                        "No se encontró la carrera académica con ID: " + command.id()));

        final CarreraAcademicaModel carreraToUpdate =
                CarreraAcademicaApplicationMapper.fromUpdateCommandToModel(command);

        final CarreraAcademicaModel updatedCarrera = updateCarreraAcademicaPort.update(carreraToUpdate);

        log.info("Carrera académica actualizada con ID: {}", updatedCarrera.getId());

        return updatedCarrera;
    }

    private void validateCommand(final UpdateCarreraAcademicaCommand command) {
        final Set<ConstraintViolation<UpdateCarreraAcademicaCommand>> violations =
                validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}