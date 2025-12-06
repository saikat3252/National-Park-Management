package com.example.simulating_operations_of_a_national_park_management.Local_Community_Member;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommunityEventsController {
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableColumn eventLocationColumn;
    @javafx.fxml.FXML
    private TableColumn regEventDateColumn;
    @javafx.fxml.FXML
    private TableColumn eventTypeColumn;
    @javafx.fxml.FXML
    private TableColumn eventSlotsColumn;
    @javafx.fxml.FXML
    private Label availableLabel;
    @javafx.fxml.FXML
    private HBox selectedEventBox;
    @javafx.fxml.FXML
    private TableView registeredEventTableView;
    @javafx.fxml.FXML
    private TableColumn regEventNameColumn;
    @javafx.fxml.FXML
    private VBox mainContainer;
    @javafx.fxml.FXML
    private TableColumn eventNameColumn;
    @javafx.fxml.FXML
    private Label selectedLabel;
    @javafx.fxml.FXML
    private TableColumn regEventActionColumn;
    @javafx.fxml.FXML
    private HBox actionBox;
    @javafx.fxml.FXML
    private TableView eventsTableView;
    @javafx.fxml.FXML
    private TableColumn regEventStatusColumn;
    @javafx.fxml.FXML
    private ComboBox EventTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn eventActionColumn;
    @javafx.fxml.FXML
    private Label ShowselectedEvent;
    @javafx.fxml.FXML
    private Label registeredLabel;
    @javafx.fxml.FXML
    private Label selectedEventName;
    @javafx.fxml.FXML
    private TableColumn eventDateColumn;
    @javafx.fxml.FXML
    private AnchorPane mainPane;
    @javafx.fxml.FXML
    private TextField searchEventTextField;
    @javafx.fxml.FXML
    private HBox searchBox;
    @javafx.fxml.FXML
    private Separator separator1;

    @javafx.fxml.FXML
    public void ViewDetailButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewregisterButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cancelRegButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashBButton(ActionEvent actionEvent) {
    }
}
