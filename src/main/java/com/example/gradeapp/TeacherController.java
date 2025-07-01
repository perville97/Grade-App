package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void onSaveTeacher() {
        String name = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Erreur", "Tous les champs sont obligatoires !");
            return;
        }

        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, 'enseignant')";

        try (Connection conn = DBConnexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password); // ⚠️ à sécuriser plus tard (hash)

            stmt.executeUpdate();

            showAlert("Succès", "Enseignant enregistré dans la base !");
            fullNameField.clear();
            emailField.clear();
            passwordField.clear();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Échec de l'enregistrement : " + e.getMessage());
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
