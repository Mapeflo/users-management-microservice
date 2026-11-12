package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteCarreraAcademicaUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteCarreraAcademicaPort;
import com.jcaa.usersmanagement.application.port.out.GetCarreraAcademicaByIdPort;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteCarreraAcademicaCommand;
import com.jcaa.usersmanagement.domain.exception.CarreraAcademicaNotFoundException;
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
public class DeleteCarreraAcademicaService implements DeleteCarreraAcademicaUseCase {

    private final DeleteCarreraAcademicaPort deleteCarreraAcademicaPort;
    private final GetCarreraAcademicaByIdPort getCarreraAcademicaByIdPort;
    private final Validator validator;

    @Override
    public void execute(final DeleteCarreraAcademicaCommand command) {
        validateCommand(command);

        // Verificar que existe antes de eliminar
        getCarreraAcademicaByIdPort
                .findById(command.id())
                .orElseThrow(() -> new CarreraAcademicaNotFoundException(
                        "No se encontró la carrera académica con ID: " + command.id()));

        deleteCarreraAcademicaPort.deleteById(command.id());

        log.info("Carrera académica eliminada con ID: {}", command.id());
    }

    private void validateCommand(final DeleteCarreraAcademicaCommand command) {
        final Set<ConstraintViolation<DeleteCarreraAcademicaCommand>> violations =
                validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}