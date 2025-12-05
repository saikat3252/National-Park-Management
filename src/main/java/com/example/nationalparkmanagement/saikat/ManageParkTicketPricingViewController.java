package com.example.nationalparkmanagement.saikat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class ManageParkTicketPricingViewController {

    @FXML private TextField priceField;
    @FXML private TextField discountField;
    @FXML private Label currentPriceLabel;
    @FXML private Label currentDiscountLabel;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "data/ticket_pricing.dat";
    private TicketPricing pricing;

    // ================= INITIALIZE =================
    @FXML
    public void initialize() {
        loadPricing();
        updateUI();
    }

    // ================= LOAD PRICING =================
    private void loadPricing() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            pricing = new TicketPricing(0, 0); // default
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            pricing = (TicketPricing) ois.readObject();
        } catch (Exception e) {
            pricing = new TicketPricing(0, 0);
            e.printStackTrace();
        }
    }

    // ================= SAVE PRICING =================
    private void savePricing() {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(pricing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE UI =================
    private void updateUI() {
        currentPriceLabel.setText("Ticket Price: " + pricing.getTicketPrice() + " BDT");
        currentDiscountLabel.setText("Discount: " + pricing.getDiscount() + " BDT");
    }

    // ================= HANDLE BUTTON =================
    @FXML
    private void handleUpdatePricing() {

        String priceText = priceField.getText().trim();
        String discountText = discountField.getText().trim();

        // Validate numeric
        try {
            double price = Double.parseDouble(priceText);
            double discount = discountText.isEmpty() ? 0 : Double.parseDouble(discountText);

            if (price < 0 || price > 2000) {
                statusLabel.setText("Ticket price must be between 0 and 2000 BDT.");
                return;
            }

            if (discount < 0 || discount > price) {
                statusLabel.setText("Discount cannot be negative or greater than price.");
                return;
            }

            // Save to memory
            pricing.setTicketPrice(price);
            pricing.setDiscount(discount);

            // Save to file
            savePricing();

            statusLabel.setText("Ticket pricing updated successfully!");
            updateUI();

        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid numeric values.");
        }
    }
}