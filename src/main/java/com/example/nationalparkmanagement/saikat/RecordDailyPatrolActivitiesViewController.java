package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class RecordDailyPatrolActivitiesViewController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> areaComboBox;

    @FXML
    private TextField patrolHoursField;

    @FXML
    private TextArea activitiesArea;

    @FXML
    private TextArea incidentArea;

    private ArrayList<PatrolRecord> patrolRecords = new ArrayList<>();

    @FXML
    public void initialize() {
        // Sample patrol areas
        areaComboBox.getItems().addAll(
                "North Zone",
                "South Forest Trail",
                "Elephant Habitat Area",
                "Wetland East",
                "Hill Patrol Route"
        );
    }

    @FXML
    private void onSavePatrolRecord() {

        LocalDate date = datePicker.getValue();
        String area = areaComboBox.getValue();
        String hoursText = patrolHoursField.getText();
        String activities = activitiesArea.getText();
        String incident = incidentArea.getText();

        if (date == null || area == null || hoursText.isEmpty() || activities.isEmpty()) {
            showAlert("Missing Information",
                    "Please fill up all required fields.");
            return;
        }

        int hours;
        try {
            hours = Integer.parseInt(hoursText);
            if (hours <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            showAlert("Invalid Hours",
                    "Patrol hours must be a positive number.");
            return;
        }

        PatrolRecord newRecord = new PatrolRecord(
                date, area, hours, activities, incident
        );

        patrolRecords.add(newRecord);

        showAlert("Success", "Patrol record saved successfully!");

        // reset fields
        datePicker.setValue(null);
        areaComboBox.setValue(null);
        patrolHoursField.clear();
        activitiesArea.clear();
        incidentArea.clear();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
}