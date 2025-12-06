package com.example.simulating_operations_of_a_national_park_management.Local_Community_Member;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CommunityFundController {
    @javafx.fxml.FXML
    private TableColumn amountTableColumn;
    @javafx.fxml.FXML
    private TextField AmountTextField;
    @javafx.fxml.FXML
    private TableColumn PurposeTableColumn;
    @javafx.fxml.FXML
    private Label MyDonationLabel;
    @javafx.fxml.FXML
    private TableColumn DateTableColumn;
    @javafx.fxml.FXML
    private ComboBox PurposeComboBox;
    @javafx.fxml.FXML
    private Label TotalDonationLabel;
    @javafx.fxml.FXML
    private TableView TableView;

    @javafx.fxml.FXML
    public void DonateOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOnActionButton(ActionEvent actionEvent) {
    }
}
