package com.example.gradeapp;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class HelloController {

    @FXML private Button loginButton;
    @FXML private Button registerButton;

    @FXML
    private void initialize() {
        setupButtonAnimations();
    }

    private void setupButtonAnimations() {
        addButtonEffects(loginButton);
        addButtonEffects(registerButton);
    }

    @FXML
    private void onLoginClicked() {
        loadNewView("login-view.fxml");
    }

    @FXML
    private void onRegisterClicked() {
        loadNewView("register-view.fxml");
    }

    private void loadNewView(String fxmlFile) {
        try {
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Transition de sortie
            FadeTransition fadeOut = new FadeTransition(Duration.millis(200), currentStage.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> {
                Scene newScene = new Scene(root);
                applyStylesheet(newScene);

                // Transition d'entrée
                root.setOpacity(0);
                FadeTransition fadeIn = new FadeTransition(Duration.millis(200), root);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);

                currentStage.setScene(newScene);
                fadeIn.play();
            });
            fadeOut.play();
        } catch (IOException e) {
            showError("Erreur de navigation", "Impossible de charger: " + fxmlFile);
        }
    }

    private void applyStylesheet(Scene scene) {
        try {
            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Fichier CSS non trouvé");
        }
    }

    private void addButtonEffects(Button button) {
        // Effet de survol
        button.setOnMouseEntered(e -> {
            animateButtonScale(button, 1.05, 1.05, 100);
            button.setStyle("-fx-background-color: derive(-fx-base, 20%);");
        });

        // Effet de sortie
        button.setOnMouseExited(e -> {
            animateButtonScale(button, 1.0, 1.0, 100);
            button.setStyle("");
        });

        // Effet de clic
        button.setOnMousePressed(e -> animateButtonScale(button, 0.95, 0.95, 50));
        button.setOnMouseReleased(e -> animateButtonScale(button, 1.0, 1.0, 50));
    }

    private void animateButtonScale(Button button, double x, double y, int duration) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(duration), button);
        scale.setToX(x);
        scale.setToY(y);
        scale.play();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), alert.getDialogPane());
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        alert.showAndWait();
        fadeIn.play();
    }
}