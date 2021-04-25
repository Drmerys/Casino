package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionController implements Initializable {
    @FXML private TextField user;
    @FXML private PasswordField password;
    @FXML private Button submit;
    @FXML private Label error;
    @FXML private Button register;
    @FXML private Button quit;



    //Gestion du clavier, pour qu'on puisse se connecter en appuyant sur Enter
    @FXML
    public void handleKeyPress(KeyEvent keyEvent) throws IOException{
        if (keyEvent.getCode() == KeyCode.ENTER){
            verify();
        }
    }

    // Gestion du clic
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        // En fonction de la source du clic, grâce à l'id du bouton, on gère l'action
        if (event.getSource() == submit){
            verify();
        }
        else if (event.getSource() == register){
            Stage stage = (Stage) register.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/View/RegisterView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();
            stage.centerOnScreen();
        }
        else if (event.getSource() == quit){
            System.exit(0);
        }
    }

    private void verify() throws IOException{
        if (!"".equals(user.getText()) && !"".equals(password.getText())){
            // Instance du model
            // Récuperation de la connexion

            /*if (){
                // Récupération du user
                // Récupération du password
                // Récupération de l'id
                // Connection

                Stage stage = (Stage) submit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/View/MenuView.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(true);
                stage.show();
                stage.centerOnScreen();
            }*/
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
