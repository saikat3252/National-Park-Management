package com.example.nationalparkmanagement.saikat;

import com.example.nationalparkmanagement.saikat.Ranger;
import com.example.nationalparkmanagement.saikat.Zone;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class AssignForestRangersViewController {

    @FXML private ComboBox<Ranger> rangerCombo;
    @FXML private ComboBox<Zone> zoneCombo;
    @FXML private ListView<String> assignmentList;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "data/ranger_assignments.dat";

    private ArrayList<String> assignments = new ArrayList<>();

    // ================== INITIALIZE UI ==================
    @FXML
    public void initialize() {

        // Sample Rangers (you can later load from file / DB)
        rangerCombo.getItems().addAll(
                new Ranger("Ranger Rahim"),
                new Ranger("Ranger Karim"),
                new Ranger("Ranger Sultana"),
                new Ranger("Ranger Babu")
        );

        // Sample Zones
        zoneCombo.getItems().addAll(
                new Zone("North Zone"),
                new Zone("South Zone"),
                new Zone("East Zone"),
                new Zone("West Zone")
        );

        // Load previous assignment history
        loadAssignments();
        assignmentList.getItems().addAll(assignments);
    }

    // ================== LOAD FROM FILE ==================
    private void loadAssignments() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            assignments = (ArrayList<String>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================== SAVE TO BINARY FILE ==================
    private void saveAssignments() {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(assignments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ================== HANDLE ASSIGN BUTTON ==================
    @FXML
    private void handleAssignRanger() {

        Ranger selectedRanger = rangerCombo.getValue();
        Zone selectedZone = zoneCombo.getValue();

        if (selectedRanger == null || selectedZone == null) {
            statusLabel.setText("Please select both Ranger and Zone!");
            return;
        }

        String assignment = selectedRanger.getName() + " ➝ " + selectedZone.getZoneName();

        // Add to list
        assignments.add(assignment);
        assignmentList.getItems().add(assignment);

        // Save to file
        saveAssignments();

        statusLabel.setText("Ranger assigned successfully!");
    }
}
