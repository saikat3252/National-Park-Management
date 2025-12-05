package com.example.nationalparkmanagement.saikat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ForestRangerViewController {

    @FXML
    public void initialize() {
    }

    // ----------- REUSABLE SCENE SWITCH METHOD -----------
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --------------- BUTTON EVENT METHODS ----------------

    @FXML
    public void Reportillegalactivitiesorincidents(ActionEvent event) {
        switchScene(event, "report-illegal-activities-view.fxml");
    }

    @FXML
    public void Trackwildlifesightings(ActionEvent event) {
        switchScene(event, "track-wildlife-sightings-view.fxml");
    }

    @FXML
    public void SubmitdailyreporttoParkAdministrator(ActionEvent event) {
        switchScene(event, "submit-daily-report-view.fxml");
    }

    @FXML
    public void Requestequipmentorsupplies(ActionEvent event) {
        switchScene(event, "request-equipment-or-supplies-view.fxml");
    }

    @FXML
    public void Checkweatherandfirealerts(ActionEvent event) {
        switchScene(event, "check-weather-and-fire-alerts-view.fxml");
    }

    @FXML
    public void Updatewildlifefeedingrecords(ActionEvent event) {
        switchScene(event, "update-wildlife-feeding-records-view.fxml");
    }

    @FXML
    public void Recorddailypatrolactivities(ActionEvent event) {
        switchScene(event, "record-daily-patrol-activities-view.fxml");
    }

    @FXML
    public void Checkassignedpatrolroutes(ActionEvent event) {
        switchScene(event, "check-assigned-patrol-routes-view.fxml");
    }
}
