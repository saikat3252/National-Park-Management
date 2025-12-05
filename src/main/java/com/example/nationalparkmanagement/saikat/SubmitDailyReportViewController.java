package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class SubmitDailyReportViewController {

    @FXML
    private TextField rangerIdField;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private TextArea reportDetailsArea;

    @FXML
    private void onSubmitReport() {

        String rangerId = rangerIdField.getText().trim();
        LocalDate reportDate = reportDatePicker.getValue();
        String reportDetails = reportDetailsArea.getText().trim();

        if (rangerId.isEmpty() || reportDate == null || reportDetails.isEmpty()) {
            showAlert("Error", "Please fill all the fields before submitting.", Alert.AlertType.ERROR);
            return;
        }

        // Create report object (can store to database later)
        DailyReport report = new DailyReport(rangerId, reportDate, reportDetails);

        // For now, only show confirmation message
        showAlert("Success", "Daily report submitted successfully!", Alert.AlertType.INFORMATION);

        clearFields();
    }

    private void clearFields() {
        rangerIdField.clear();
        reportDatePicker.setValue(null);
        reportDetailsArea.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}