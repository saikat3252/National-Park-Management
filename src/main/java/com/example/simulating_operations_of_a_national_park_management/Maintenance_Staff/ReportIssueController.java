package com.example.simulating_operations_of_a_national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportIssueController {
    @javafx.fxml.FXML
    private ComboBox issueTypeComboBox;
    @javafx.fxml.FXML
    private TextField locationField;
    @javafx.fxml.FXML
    private Button submitButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button validateButton;
    @javafx.fxml.FXML
    private TextArea descriptionField;
    @javafx.fxml.FXML
    private ComboBox severityComboBox;

    @javafx.fxml.FXML
    public void OnActionsubmitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleValidateForm(ActionEvent actionEvent) {
    }
}
