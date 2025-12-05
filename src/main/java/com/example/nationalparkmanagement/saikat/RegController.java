package org.example;

public class RegController import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportController {

    @FXML
    private TextField reportNameField;

    @FXML
    private TextField reportNumberField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Spinner<?> timeSpinner;

    @FXML
    private TextArea reportDetailsArea;

    @FXML
    private Button generateButton;

    @FXML
    private void initialize() {
        // This runs automatically when the FXML loads
        System.out.println("ReportController initialized!");
    }

    @FXML
    private void handleGenerateReport() {

        String name = reportNameField.getText();
        String number = reportNumberField.getText();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
        Object time = timeSpinner.getValue();
        String details = reportDetailsArea.getText();

        System.out.println("=== Report Generated ===");
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Details: " + details);
    }
}
{
}
