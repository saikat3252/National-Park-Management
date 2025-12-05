package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackWildlifeSightingsViewController {

    @FXML
    private ComboBox<String> speciesCombo;

    @FXML
    private ComboBox<String> locationCombo;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField timeField;

    @FXML
    private TextField countField;

    @FXML
    private TextArea notesArea;

    private final String FILE_PATH = "data/wildlife_sightings.bin";
    private ArrayList<WildlifeSighting> sightings = new ArrayList<>();

    @FXML
    public void initialize() {

        speciesCombo.getItems().addAll(
                "Elephant", "Tiger", "Deer", "Monkey",
                "Wild Boar", "Crocodile", "Bird (Unknown)",
                "Snake", "Leopard", "Fox"
        );

        locationCombo.getItems().addAll(
                "North Zone", "South Zone", "Wetlands",
                "Elephant Corridor", "River Side",
                "Hill Area", "Grassland"
        );

        loadSightings();
    }

    @FXML
    private void onSaveSighting() {

        String species = speciesCombo.getValue();
        String location = locationCombo.getValue();
        LocalDate date = datePicker.getValue();
        String time = timeField.getText();
        String countText = countField.getText();
        String notes = notesArea.getText();

        if (species == null || location == null || date == null ||
                time.isEmpty() || countText.isEmpty()) {

            showAlert("Missing Fields",
                    "Please fill all required fields.");
            return;
        }

        int count;
        try {
            count = Integer.parseInt(countText);
            if (count <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            showAlert("Invalid Count",
                    "Number of animals must be a positive number.");
            return;
        }

        WildlifeSighting sighting = new WildlifeSighting(
                species, location, date, time, count, notes
        );

        sightings.add(sighting);
        saveSightings();

        showAlert("Success",
                "Wildlife sighting data saved successfully!");

        clearFields();
    }

    private void clearFields() {
        speciesCombo.setValue(null);
        locationCombo.setValue(null);
        datePicker.setValue(null);
        timeField.clear();
        countField.clear();
        notesArea.clear();
    }


    /** Save to binary file */
    private void saveSightings() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(sightings);
        } catch (IOException e) {
            showAlert("Error", "Failed to save sightings!");
        }
    }

    /** Load previous data */
    private void loadSightings() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_PATH))) {

            sightings = (ArrayList<WildlifeSighting>) ois.readObject();

        } catch (Exception e) {
            sightings = new ArrayList<>();
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
