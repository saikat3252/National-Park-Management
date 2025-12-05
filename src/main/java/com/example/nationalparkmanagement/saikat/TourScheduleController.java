package org.example;

public class TourScheduleController import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TourScheduleController {

    @FXML
    private TextField scheduleIdField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tourNameField;

    @FXML
    private Spinner<Integer> timeSpinner;

    @FXML
    private Button enterScheduleButton;

    @FXML
    private TextArea enterScheduleArea;

    @FXML
    public void initialize() {
        // Initialize the spinner with values for time (0-23 hours)
        timeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 10));
    }

    @FXML
    private void onEnterScheduleClicked() {

        String scheduleId = scheduleIdField.getText();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "Not Selected";
        String tourName = tourNameField.getText();
        int time = timeSpinner.getValue();

        // Build the output string
        StringBuilder details = new StringBuilder();
        details.append("Schedule ID: ").append(scheduleId).append("\n");
        details.append("Tour Name: ").append(tourName).append("\n");
        details.append("Date: ").append(date).append("\n");
        details.append("Time: ").append(time).append(":00").append("\n");

        // Display in TextArea
        enterScheduleArea.setText(details.toString());
    }
}
