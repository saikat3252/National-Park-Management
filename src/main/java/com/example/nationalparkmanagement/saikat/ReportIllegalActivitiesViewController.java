package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportIllegalActivitiesViewController {

    @FXML
    private TextField rangerNameField;

    @FXML
    private ComboBox<String> activityTypeCombo;

    @FXML
    private ComboBox<String> locationCombo;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionArea;

    private final String FILE_PATH = "data/illegal_reports.bin";
    private ArrayList<IllegalActivityReport> reports = new ArrayList<>();

    @FXML
    public void initialize() {

        // Activity types
        activityTypeCombo.getItems().addAll(
                "Poaching",
                "Illegal Logging",
                "Unauthorized Vehicle Entry",
                "Wildlife Harassment",
                "Illegal Fishing",
                "Forest Fire"
        );

        // Locations
        locationCombo.getItems().addAll(
                "North Zone",
                "South Zone",
                "Wetland Area",
                "Elephant Habitat",
                "River Side",
                "Mountain Patrol Route"
        );

        // Load previous reports if exist
        loadReports();
    }

    @FXML
    private void onSubmitReport() {

        String rangerName = rangerNameField.getText();
        String activityType = activityTypeCombo.getValue();
        String location = locationCombo.getValue();
        LocalDate date = datePicker.getValue();
        String description = descriptionArea.getText();

        if (rangerName.isEmpty() || activityType == null || location == null ||
                date == null || description.isEmpty()) {

            showAlert("Missing Fields",
                    "Please fill all fields before submitting.");
            return;
        }

        IllegalActivityReport report = new IllegalActivityReport(
                rangerName, activityType, location, date, description
        );

        reports.add(report);
        saveReports();

        showAlert("Success", "Illegal activity report submitted successfully!");

        clearFields();
    }

    private void clearFields() {
        rangerNameField.clear();
        activityTypeCombo.setValue(null);
        locationCombo.setValue(null);
        datePicker.setValue(null);
        descriptionArea.clear();
    }

    /** Save using binary file */
    private void saveReports() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            oos.writeObject(reports);

        } catch (IOException e) {
            showAlert("Error", "Failed to save data!");
        }
    }

    /** Load previous binary file */
    private void loadReports() {

        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_PATH))) {

            reports = (ArrayList<IllegalActivityReport>) ois.readObject();

        } catch (Exception e) {
            reports = new ArrayList<>();
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}