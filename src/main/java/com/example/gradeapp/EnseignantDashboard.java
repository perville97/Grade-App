package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnseignantDashboard {

    @FXML
    private Label welcomeLabel;

    @FXML
    private void onViewMyCourses() {
        System.out.println("Bouton 'Voir Mes Cours' cliqué !");
        // logiques ou affichage de la vue cours ici
    }

    @FXML
    private void onViewMyClasses() {
        System.out.println("Bouton 'Voir Mes Classes' cliqué !");
        // logiques ou affichage de la vue classes ici
    }

    @FXML
    private void onFillGrades() {
        System.out.println("Bouton 'Remplir Notes' cliqué !");
        // logiques ou affichage de la vue notes ici
    }
}
