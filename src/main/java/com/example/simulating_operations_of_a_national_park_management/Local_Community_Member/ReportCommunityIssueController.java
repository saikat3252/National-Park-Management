package com.example.simulating_operations_of_a_national_park_management.Local_Community_Member;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ReportCommunityIssueController {
    @javafx.fxml.FXML
    private ComboBox issueTypeComboBox;
    @javafx.fxml.FXML
    private TextField LocationTextField;
    @javafx.fxml.FXML
    private TextArea DetailsTextArea;
    @javafx.fxml.FXML
    private TableColumn IssueIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox PriorityComboBox;
    @javafx.fxml.FXML
    private TableColumn StatusTableColumn;
    @javafx.fxml.FXML
    private TableView IssueReportsTableView;
    @javafx.fxml.FXML
    private TableColumn TyoeTableColumn;

    @javafx.fxml.FXML
    public void CancelOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOnActionButton(ActionEvent actionEvent) {
    }
}
