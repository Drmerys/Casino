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
import org.casinojfx.Model.ConnectionModel;
import org.casinojfx.Model.DataBaseConnectionModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionController implements Initializable {
    // Récupération des contrôles de la vue
    @FXML private TextField user;
    @FXML private PasswordField password;
    @FXML private Button submit;
    @FXML private Label error;
    @FXML private Button register;
    @FXML private Button quit;
    private DataBaseConnectionModel dataBaseConnectionModel;
    private ConnectionModel connectionModel;



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

    // Méthode de vérification des informations soumises
    public void verify() throws IOException{
        if (!"".equals(user.getText()) && !"".equals(password.getText()))
        {
            dataBaseConnectionModel = DataBaseConnectionModel.getInstance();
            connectionModel = dataBaseConnectionModel.getConnectionModel();
            if (connectionModel.connect(user.getText(), password.getText()))
            {
                dataBaseConnectionModel.setUser(connectionModel.getUser());
                dataBaseConnectionModel.setPassword(connectionModel.getPassword());
                dataBaseConnectionModel.setConnection();

                Stage stage = (Stage) submit.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/View/MenuView.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                //stage.setResizable(true);
                stage.show();
                stage.centerOnScreen();
            }
            else
            {
                error.setText("Identifiant et/ou mot de passe incorrect(s) !");
                password.clear();
                password.requestFocus();
            }
        }
        else
        {
            error.setText("Merci de remplir tous les champs ! ");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
