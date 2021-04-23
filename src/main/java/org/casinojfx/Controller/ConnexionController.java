package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnexionController implements Initializable {
    @FXML
    public TextField user;
    @FXML
    public PasswordField password;
    @FXML
    public Button submit;
    @FXML
    public Button quit;
    @FXML
    public Label error;

    @FXML
    public void handleKeyPress(KeyEvent keyEvent) {
    }

    @FXML
    public void handleButtonAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
