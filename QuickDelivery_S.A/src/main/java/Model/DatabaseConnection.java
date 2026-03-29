package Model;

﻿package com.mycompany.quickdelivery_s.a.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase utilitaria para manejar conexiones a base de datos MySQL
 * Implementa el patrón Singleton para reutilizar conexiones
 */
public class DatabaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    
    // Configuración de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/quickdelivery_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña_aqui"; // Cambia esto por tu contraseña real
    
    private static DatabaseConnection instance;
    private Connection connection;
    
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Conexión a base de datos establecida exitosamente");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error al conectar con la base de datos: " + e.getMessage());
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                logger.info("Conexión restablecida");
            }
        } catch (SQLException e) {
            logger.error("Error al obtener conexión: " + e.getMessage());
            throw new RuntimeException("Error al obtener conexión", e);
        }
        return connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                logger.info("Conexión cerrada");
            } catch (SQLException e) {
                logger.error("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
