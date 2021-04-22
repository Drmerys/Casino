module casino {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.casinojfx to javafx.fxml;
    exports org.casinojfx;
}