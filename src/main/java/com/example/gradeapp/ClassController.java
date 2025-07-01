package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class ClassController {

    @FXML
    private TextField classNameField;

    @FXML
    private void onSaveClass() {
        String className = classNameField.getText();
        if (className.isEmpty()) {
            showAlert("Erreur", "Le nom de la classe ne peut pas être vide !");
        } else {
            System.out.println("Classe enregistrée : " + className);
            showAlert("Succès", "Classe créée avec succès !");
            classNameField.clear();
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
