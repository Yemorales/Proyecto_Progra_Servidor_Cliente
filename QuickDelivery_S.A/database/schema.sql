-- Script de creación de base de datos para QuickDelivery S.A.
DROP DATABASE IF EXISTS quickdelivery_db;
CREATE DATABASE quickdelivery_db CHARACTER SET utf8mb4;
USE quickdelivery_db;

-- Tabla de Roles
CREATE TABLE roles (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre_rol VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- Tabla de Usuarios
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    id_rol INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'ACTIVO',
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);

-- Tabla de Tipos de Vehículo
CREATE TABLE tipos_vehiculo (
    id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre_tipo VARCHAR(50) NOT NULL UNIQUE,
    capacidad_kg DECIMAL(10,2)
);

-- Tabla de Vehículos
CREATE TABLE vehiculos (
    id_vehiculo INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(20) NOT NULL UNIQUE,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    id_tipo INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'DISPONIBLE',
    latitud DECIMAL(10,8),
    longitud DECIMAL(11,8),
    FOREIGN KEY (id_tipo) REFERENCES tipos_vehiculo(id_tipo)
);

-- Tabla de Conductores
CREATE TABLE conductores (
    id_conductor INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL UNIQUE,
    numero_licencia VARCHAR(50) UNIQUE,
    id_vehiculo INT,
    estado VARCHAR(20) DEFAULT 'DISPONIBLE',
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo)
);

-- Tabla de Estados de Paquete
CREATE TABLE estados_paquete (
    id_estado INT PRIMARY KEY AUTO_INCREMENT,
    nombre_estado VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla de Paquetes
CREATE TABLE paquetes (
    id_paquete INT PRIMARY KEY AUTO_INCREMENT,
    numero_seguimiento VARCHAR(50) UNIQUE,
    id_remitente INT,
    id_destinatario INT,
    peso_kg DECIMAL(10,2),
    descripcion TEXT,
    id_estado INT NOT NULL,
    direccion_entrega VARCHAR(255),
    ciudad VARCHAR(100),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_remitente) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_destinatario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_estado) REFERENCES estados_paquete(id_estado)
);

-- Tabla de Asignaciones
CREATE TABLE asignaciones_paquetes (
    id_asignacion INT PRIMARY KEY AUTO_INCREMENT,
    id_paquete INT NOT NULL,
    id_vehiculo INT NOT NULL,
    id_conductor INT NOT NULL,
    fecha_asignacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) DEFAULT 'ASIGNADO',
    FOREIGN KEY (id_paquete) REFERENCES paquetes(id_paquete),
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo),
    FOREIGN KEY (id_conductor) REFERENCES conductores(id_conductor)
);

-- Tabla de Ubicaciones
CREATE TABLE ubicaciones_vehiculos (
    id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,
    id_vehiculo INT NOT NULL,
    latitud DECIMAL(10,8),
    longitud DECIMAL(11,8),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculos(id_vehiculo)
);

-- Tabla de Incidencias
CREATE TABLE incidencias (
    id_incidencia INT PRIMARY KEY AUTO_INCREMENT,
    id_paquete INT,
    tipo_incidencia VARCHAR(50),
    descripcion TEXT,
    estado VARCHAR(20) DEFAULT 'ABIERTA',
    fecha_reporte TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_paquete) REFERENCES paquetes(id_paquete)
);

-- Tabla de Logs
CREATE TABLE logs_sistema (
    id_log INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    tipo_evento VARCHAR(50),
    descripcion TEXT,
    fecha_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- DATOS INICIALES
INSERT INTO roles (nombre_rol, descripcion) VALUES
('ADMINISTRADOR', 'Acceso total'),
('DESPACHADOR', 'Gestiona entregas'),
('CONDUCTOR', 'Realiza entregas');

INSERT INTO tipos_vehiculo (nombre_tipo, capacidad_kg) VALUES
('Moto', 25),
('Auto', 50),
('Camioneta', 150);

INSERT INTO estados_paquete (nombre_estado) VALUES
('PENDIENTE'), ('EN_TRANSITO'), ('ENTREGADO'), ('INCIDENCIA');

INSERT INTO usuarios (nombre, email, usuario, contraseña, id_rol) VALUES
('Admin', 'admin@qd.com', 'admin', 'admin123', 1),
('Juan Pérez', 'juan@qd.com', 'juan', 'juan123', 2),
('Carlos López', 'carlos@qd.com', 'carlos', 'carlos123', 3);
