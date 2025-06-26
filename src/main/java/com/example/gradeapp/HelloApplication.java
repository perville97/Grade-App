package com.example.gradeapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 700); // Taille encore plus grande

            // Configuration de la fenêtre
            stage.setTitle("GradeApp - Gestion Académique Intelligente");
            stage.setScene(scene);
            stage.setResizable(true);

            // Tailles minimales et maximales
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.setMaxWidth(1400);
            stage.setMaxHeight(1000);

            // Centrer la fenêtre sur l'écran
            stage.centerOnScreen();

            // Optionnel : Maximiser au démarrage
            // stage.setMaximized(true);

            stage.show();

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'interface : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}