module com.example.gradeapp {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.gradeapp to javafx.fxml;
    exports com.example.gradeapp;
}