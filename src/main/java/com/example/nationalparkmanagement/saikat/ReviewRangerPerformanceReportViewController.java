package com.example.nationalparkmanagement.saikat;



import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;

public class ReviewRangerPerformanceReportViewController {

    @FXML
    private ComboBox<Ranger> rangerComboBox;
    @FXML
    private Label lblName, lblPatrolHours, lblTasksCompleted, lblIncidentsHandled, lblRating;
    @FXML
    private TextArea remarksArea;

    private HashMap<Integer, RangerPerformanceReport> reportData = new HashMap<>();

    @FXML
    public void initialize() {
        // Sample Rangers
        Ranger r1 = new Ranger(1, "Ranger Saikat");
        Ranger r2 = new Ranger(2, "Ranger Mahmud");
        Ranger r3 = new Ranger(3, "Ranger Karim");

        rangerComboBox.getItems().addAll(r1, r2, r3);

        // Dummy Report Data
        reportData.put(1, new RangerPerformanceReport(r1, 48, 12, 3, 4.5, "Good performance."));
        reportData.put(2, new RangerPerformanceReport(r2, 36, 8, 1, 3.8, "Needs improvement."));
        reportData.put(3, new RangerPerformanceReport(r3, 55, 15, 4, 4.9, "Excellent ranger."));
    }

    @FXML
    private void onLoadReport() {
        Ranger selected = rangerComboBox.getValue();

        if (selected == null) {
            showAlert("Error", "Please select a ranger.");
            return;
        }

        RangerPerformanceReport report = reportData.get(selected.getId());

        if (report == null) {
            showAlert("No Report", "No report found for this ranger.");
            return;
        }

        lblName.setText(report.getRanger().getName());
        lblPatrolHours.setText(report.getPatrolHours() + " hrs");
        lblTasksCompleted.setText(String.valueOf(report.getTasksCompleted()));
        lblIncidentsHandled.setText(String.valueOf(report.getIncidentsHandled()));
        lblRating.setText(String.valueOf(report.getRating()));
        remarksArea.setText(report.getRemarks());
    }

    @FXML
    private void onSaveRemarks() {
        Ranger selected = rangerComboBox.getValue();

        if (selected == null) {
            showAlert("Error", "Please select a ranger.");
            return;
        }

        RangerPerformanceReport report = reportData.get(selected.getId());
        report.setRemarks(remarksArea.getText());

        showAlert("Success", "Remarks saved successfully!");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
}
