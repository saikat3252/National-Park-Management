package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    @FXML
    private TextField reportNameField;

    @FXML
    private TextField reportNumberField;

    @FXML
    private TextField dateField;

    @FXML
    private Spinner<Integer> timeSpinner;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Button generateReportButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set default spinner values if timeSpinner is present
        if (timeSpinner != null) {
            timeSpinner.setValueFactory(
                    new javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory(1, 24, 12)
            );
        }
    }

    @FXML
    private void onGenerateReport() {
        String reportName = reportNameField.getText();
        String reportNumber = reportNumberField.getText();
        String date = dateField.getText();
        Integer time = timeSpinner.getValue();
        String description = descriptionArea.getText();

        System.out.println("=== REPORT DATA ===");
        System.out.println("Name: " + reportName);
        System.out.println("Number: " + reportNumber);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Description: " + description);
        System.out.println("===================");
    }
}

