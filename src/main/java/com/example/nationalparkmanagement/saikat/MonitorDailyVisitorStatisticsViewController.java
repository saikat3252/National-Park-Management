package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MonitorDailyVisitorStatisticsViewController {

    @FXML private Label totalVisitorsLabel;
    @FXML private Label peakHourLabel;
    @FXML private Label salesLabel;
    @FXML private ListView<String> visitorList;

    private final String FILE_PATH = "data/visitor_entries.dat";

    // ================= LOAD ENTRIES =================
    private ArrayList<VisitorEntry> loadEntries() {
        File file = new File(FILE_PATH);

        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<VisitorEntry>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ================= BUTTON ACTION =================
    @FXML
    private void handleViewReport() {
        ArrayList<VisitorEntry> entries = loadEntries();

        visitorList.getItems().clear();

        // Filter only today's entries
        ArrayList<VisitorEntry> todayEntries = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (VisitorEntry e : entries) {
            if (e.getEntryTime().toLocalDate().isEqual(today)) {
                todayEntries.add(e);
                visitorList.getItems().add(
                        e.getVisitorName() + " - " + e.getEntryTime().toLocalTime()
                );
            }
        }

        // ======= Calculate total visitors =======
        totalVisitorsLabel.setText(String.valueOf(todayEntries.size()));

        // ======= Calculate ticket sales =======
        double totalSales = 0;
        for (VisitorEntry e : todayEntries) {
            totalSales += e.getTicketPrice();
        }
        salesLabel.setText(totalSales + " BDT");

        // ======= Determine peak hour =======
        HashMap<Integer, Integer> hourlyCount = new HashMap<>();

        for (VisitorEntry e : todayEntries) {
            int hour = e.getEntryTime().getHour();
            hourlyCount.put(hour, hourlyCount.getOrDefault(hour, 0) + 1);
        }

        if (hourlyCount.isEmpty()) {
            peakHourLabel.setText("--");
            return;
        }

        int peakHour = Collections.max(hourlyCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        peakHourLabel.setText(peakHour + ":00");

    }
}