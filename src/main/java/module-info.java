module com.example.nationalparkmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.nationalparkmanagement to javafx.fxml;
    opens com.example.nationalparkmanagement.saikat to javafx.fxml;
    exports com.example.nationalparkmanagement;
}