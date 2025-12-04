module com.example.nationalparkmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nationalparkmanagement to javafx.fxml;
    exports com.example.nationalparkmanagement;
}