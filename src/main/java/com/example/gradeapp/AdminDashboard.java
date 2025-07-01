package com.example.gradeapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

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

    private void openNewWindow(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCreateLevels() {
        openNewWindow("LevelCreationView.fxml", "Créer Niveaux");
    }

    @FXML
    private void onCreateClasses() {
        openNewWindow("ClassCreationView.fxml", "Créer Classes");
    }

    @FXML
    private void onCreateTeachers() {
        openNewWindow("TeacherCreationView.fxml", "Créer Enseignants");
    }

    @FXML
    private void onCreateCourses() {
        openNewWindow("CourseCreationView.fxml", "Créer Cours");
    }

    @FXML
    private void onCreateStudents() {
        openNewWindow("StudentCreationView.fxml", "Créer Élèves");
    }

    @FXML
    private void onGenerateAnonymats() {
        openNewWindow("AnonymatGenerationView.fxml", "Générer Anonymats");
    }

    @FXML
    private void onViewResults() {
        openNewWindow("ResultView.fxml", "Consulter Résultats");
    }
}
