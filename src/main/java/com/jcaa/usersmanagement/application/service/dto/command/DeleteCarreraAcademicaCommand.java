package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotNull;

public record DeleteCarreraAcademicaCommand(
        @NotNull(message = "id must not be null")
        Long id
) {
}