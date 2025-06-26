package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void onLoginClicked() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        try (Connection conn = DBConnexion.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                showAlert("Succès", "Connexion réussie. Bienvenue, " + rs.getString("name") + " !");
                // Tu peux ici changer de scène ou ouvrir une nouvelle fenêtre
            } else {
                showAlert("Erreur", "Email ou mot de passe incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Erreur de connexion à la base de données.");
        }
    }


    @FXML
    private void onRegisterClicked() {
        showAlert("Créer un compte", "Redirection vers la page d'inscription...");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
