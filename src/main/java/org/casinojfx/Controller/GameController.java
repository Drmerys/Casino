package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML private TableView table;
    @FXML private TableColumn playerAvailable;
    @FXML private TableColumn rank;
    @FXML private Button back;
    @FXML private Button quit;
    @FXML private Button disconnect;
    @FXML private RadioButton launchGame;



    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == back)
        {
            redirect("Menu");
        }
        else if (event.getSource() == disconnect)
        {
            redirect("Connection");
        }
        else if (event.getSource() == quit)
        {
            System.exit(0);
        }
    }

    @FXML
    public void handleRadioButtonAction(ActionEvent event) {
        if (event.getSource() == launchGame)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lancement de la partie!");
            alert.setHeaderText("Selection des joueurs ! ");
            alert.setContentText("La va se lancer !");
            alert.showAndWait();
        }
    }

    public void redirect(String view) throws IOException {
        Stage stage = (Stage) table.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/"+view+"View.fxml")); // /View/MenuView.fxml
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
