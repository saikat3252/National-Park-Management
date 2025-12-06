module com.example.simulating_operations_of_a_national_park_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.simulating_operations_of_a_national_park_management to javafx.fxml;
    exports com.example.simulating_operations_of_a_national_park_management;
}