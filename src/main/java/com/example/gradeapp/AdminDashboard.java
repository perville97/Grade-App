package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminDashboard {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button createLevelsButton;

    @FXML
    private Button createClassesButton;

    @FXML
    private Button createTeachersButton;

    @FXML
    private Button createCoursesButton;

    @FXML
    private Button createStudentsButton;

    @FXML
    private Button generateAnonymatsButton;

    @FXML
    private Button viewResultsButton;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Bienvenue dans le tableau de bord administrateur !");
    }

    @FXML
    private void onCreateLevels() {
        System.out.println("Créer les niveaux...");
    }

    @FXML
    private void onCreateClasses() {
        System.out.println("Créer les classes...");
    }

    @FXML
    private void onCreateTeachers() {
        System.out.println("Créer les enseignants...");
    }

    @FXML
    private void onCreateCourses() {
        System.out.println("Créer les cours...");
    }

    @FXML
    private void onCreateStudents() {
        System.out.println("Créer les élèves...");
    }

    @FXML
    private void onGenerateAnonymats() {
        System.out.println("Génération des anonymats...");
    }

    @FXML
    private void onViewResults() {
        System.out.println("Consultation de tous les résultats...");
    }
}
