package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class CourseController {

    @FXML
    private TextField courseNameField;

    @FXML
    private void onSaveCourse() {
        String courseName = courseNameField.getText();
        if (courseName.isEmpty()) {
            showAlert("Erreur", "Le nom du cours est requis !");
        } else {
            System.out.println("Cours enregistré : " + courseName);
            showAlert("Succès", "Cours créé avec succès !");
            courseNameField.clear();
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
