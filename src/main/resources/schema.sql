-- =============================================
-- Script de creación de la base de datos
-- Gestión de Usuarios + Carrera Académica
-- =============================================

CREATE DATABASE IF NOT EXISTS crud_usuarios_spring
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE crud_usuarios_spring;

-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
                                     id          VARCHAR(50)  NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(150) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    role        VARCHAR(50)  NOT NULL,
    status      VARCHAR(50)  NOT NULL DEFAULT 'PENDING',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Usuario administrador (password: password)
INSERT INTO users (id, name, email, password, role, status)
VALUES (
           'admin-001',
           'Administrador',
           'admin@crud.com',
           '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi',
           'ADMIN',
           'ACTIVE'
       );

-- Tabla de Carreras Académicas
CREATE TABLE IF NOT EXISTS carreras_academicas (
                                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                   nombre VARCHAR(150) NOT NULL,
    num_creditos INT NOT NULL,
    num_asignaturas INT NOT NULL,
    num_semestres INT NOT NULL,
    nivel_formacion VARCHAR(50) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    valor_semestre DECIMAL(12,2) NOT NULL,
    universidad VARCHAR(150) NOT NULL,
    es_acreditada BOOLEAN NOT NULL DEFAULT FALSE,
    perfiles TEXT,
    area_conocimiento VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

