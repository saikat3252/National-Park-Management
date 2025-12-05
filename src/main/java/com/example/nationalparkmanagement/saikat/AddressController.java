package org.example;

public class AddressController import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddressController {

    @FXML
    private TextField streetField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField zipcodeField;

    @FXML
    private ComboBox<String> countryLabel; // your naming choice

    @FXML
    private Button enterButton;

    @FXML
    private TextArea enterDetailsArea;

    @FXML
    public void initialize() {
        // Add sample countries to ComboBox (optional)
        countryLabel.getItems().addAll("Bangladesh", "India", "USA", "UK", "Canada");
    }

    @FXML
    private void onEnterClicked() {

        String street = streetField.getText();
        String city = cityField.getText();
        String zipcode = zipcodeField.getText();
        String country = countryLabel.getValue();

        // Create formatted output
        StringBuilder details = new StringBuilder();
        details.append("Street: ").append(street).append("\n");
        details.append("City: ").append(city).append("\n");
        details.append("Zip Code: ").append(zipcode).append("\n");
        details.append("Country: ").append(country).append("\n");

        // Display in the TextArea
        enterDetailsArea.setText(details.toString());
    }
}{
}
