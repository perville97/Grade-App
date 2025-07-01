package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class AnonymatController {

    @FXML
    private void onGenerate() {
        // Simuler la génération
        System.out.println("Anonymats générés !");
        showAlert("Succès", "Les anonymats ont été générés !");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
