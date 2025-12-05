package com.example.nationalparkmanagement.saikat;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class RegisterVisitorViewController {

    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private TextField contactField;
    @FXML private TextField uidField;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "data/visitors.dat";

    // ==================== Load Visitors ====================
    private ArrayList<Visitor> loadVisitors() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Visitor>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ==================== Save Visitors ====================
    private void saveVisitors(ArrayList<Visitor> visitorList) {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(visitorList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ==================== Register Visitor Button ====================
    @FXML
    private void handleRegisterVisitor() {

        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String contact = contactField.getText().trim();
        String uid = uidField.getText().trim();

        // -------- Validation --------
        if (name.isEmpty() || ageText.isEmpty() || contact.isEmpty() || uid.isEmpty()) {
            statusLabel.setText("Please fill all fields!");
            return;
        }

        int age;

        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            statusLabel.setText("Age must be a number!");
            return;
        }

        // -------- Load existing visitors --------
        ArrayList<Visitor> visitorList = loadVisitors();

        // -------- Check duplicate UID --------
        for (Visitor v : visitorList) {
            if (v.getUid().equals(uid)) {
                statusLabel.setText("Visitor already exists!");
                return;
            }
        }

        // -------- Add new visitor --------
        Visitor newVisitor = new Visitor(name, age, contact, uid);
        visitorList.add(newVisitor);

        saveVisitors(visitorList);

        statusLabel.setText("Visitor successfully registered!");

        // Clear fields
        nameField.clear();
        ageField.clear();
        contactField.clear();
        uidField.clear();
    }
}
