module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;
    opens com.example.dictionary.controller to javafx.fxml;
}