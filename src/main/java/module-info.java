module com.example.morpionjohanne {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.morpionjohanne to javafx.fxml;
    exports com.example.morpionjohanne;
}