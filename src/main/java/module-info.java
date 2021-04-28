module Casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens org.casinojfx.Controller to javafx.fxml;
    exports org.casinojfx.Controller;
}