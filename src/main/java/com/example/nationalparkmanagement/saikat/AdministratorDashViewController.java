package com.example.nationalparkmanagement.saikat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdministratorDashViewController
{
    // Initialize if needed
    @javafx.fxml.FXML
    public void initialize() {
    }

    // Universal Scene Switcher
    private void switchScene(String fxml, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // -------------------------------
    // Button Actions (Scene Switching)
    // -------------------------------

    @javafx.fxml.FXML
    public void Registernewvisitorstothepark(ActionEvent actionEvent) {
        switchScene("register-visitor-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void assignForestRangers(ActionEvent actionEvent) {
        switchScene("assign-forest-rangers-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void monitorDailyVisitorStats(ActionEvent actionEvent) {
        switchScene("monitor-daily-visitor-statistics-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void manageTicketPricing(ActionEvent actionEvent) {
        switchScene("manage-park-ticket-pricing-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void reviewRangerPerformance(ActionEvent actionEvent) {
        switchScene("review-ranger-performance-report-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void manageMaintenanceSchedules(ActionEvent actionEvent) {
        switchScene("manage-maintenance-schedules-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void handleWildlifeHealth(ActionEvent actionEvent) {
        switchScene("handle-wildlife-health-view.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void generateMonthlyReport(ActionEvent actionEvent) {
        switchScene("generate-monthly-view.fxml", actionEvent);
    }
}
