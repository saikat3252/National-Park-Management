package com.example.nationalparkmanagement.saikat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CheckAssignedPatrolRoutesViewController {

    @FXML
    private TextField rangerIdField;

    @FXML
    private TableView<PatrolRoute> routeTable;

    @FXML
    private TableColumn<PatrolRoute, String> colRouteId;

    @FXML
    private TableColumn<PatrolRoute, String> colRegion;

    @FXML
    private TableColumn<PatrolRoute, String> colSchedule;

    private ObservableList<PatrolRoute> routes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colRouteId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getRouteId()));
        colRegion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getRegion()));
        colSchedule.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getSchedule()));

        routeTable.setItems(routes);
    }

    @FXML
    private void onSearchRoute() {
        String rangerId = rangerIdField.getText().trim();

        if (rangerId.isEmpty()) {
            showAlert("Error", "Please enter a Ranger ID!", Alert.AlertType.ERROR);
            return;
        }

        // Dummy Data (Replace later with database query)
        routes.clear();

        if (rangerId.equals("101")) {
            routes.add(new PatrolRoute("R-22", "North Forest", "06:00 AM - 12:00 PM"));
            routes.add(new PatrolRoute("R-25", "East Lake", "01:00 PM - 06:00 PM"));
        } else if (rangerId.equals("102")) {
            routes.add(new PatrolRoute("R-14", "South Hills", "07:00 AM - 01:00 PM"));
        } else {
            showAlert("No Routes Found", "No patrol routes assigned for Ranger ID: " + rangerId, Alert.AlertType.INFORMATION);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}