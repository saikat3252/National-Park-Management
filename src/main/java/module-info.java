module com.example.simulating_operations_of_a_national_park_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simulating_operations_of_a_national_park_management to javafx.fxml;
    exports com.example.simulating_operations_of_a_national_park_management;
}