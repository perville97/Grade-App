package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.Connection;


public class RegisterController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void onCreateAccountClicked() {
        String name = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
        } else {
            if (saveUserToDatabase(name, email, password)) {
                showAlert("Compte créé", "Bienvenue " + name + " !");
            } else {
                showAlert("Erreur", "Échec de la création du compte.");
            }
        }
    }


    private boolean saveUserToDatabase(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, 'eleve')";

        try (Connection conn = DBConnexion.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password); // ⚠️ À chiffrer en production !

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
