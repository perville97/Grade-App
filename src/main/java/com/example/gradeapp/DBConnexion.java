package com.example.gradeapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnexion {
    // Configuration - À externaliser dans un fichier de configuration en production
    private static final String URL = "jdbc:mysql://localhost:3306/database?useSSL=false&serverTimezone=UTC";
    private static final String USER = "popsmoke";
    private static final String PASSWORD = "root"; // À changer absolument en production!
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            // Chargement du driver
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Driver MySQL non trouvé");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Connexion réussie à MySQL");
            System.out.println("🔷 Version serveur: " + conn.getMetaData().getDatabaseProductVersion());
            System.out.println("🔷 URL de connexion: " + conn.getMetaData().getURL());
        } catch (SQLException e) {
            System.err.println("❌ Échec de la connexion:");
            System.err.println("Code d'erreur: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testConnection();
    }
}