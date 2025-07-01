package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class LevelController {

    @FXML
    private TextField levelNameField;

    @FXML
    private void onSaveLevel() {
        String levelName = levelNameField.getText();
        if (levelName.isEmpty()) {
            showAlert("Erreur", "Le nom du niveau ne peut pas être vide !");
        } else {
            // Tu peux ici enregistrer dans la base de données
            System.out.println("Niveau enregistré : " + levelName);
            showAlert("Succès", "Niveau créé avec succès !");
            levelNameField.clear();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
