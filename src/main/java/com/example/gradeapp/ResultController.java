package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ResultController {

    @FXML
    private void onViewResults() {
        // Simuler la récupération des résultats
        System.out.println("Résultats affichés !");
        showAlert("Info", "Les résultats sont affichés ici.");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
