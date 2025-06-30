package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EleveDashboard {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button viewBulletinButton;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Bienvenue Élève !");
    }

    @FXML
    private void onViewBulletin() {
        System.out.println("Afficher le bulletin de l'élève...");
    }
}
