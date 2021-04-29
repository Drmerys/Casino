package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button disconnect;
    public Button game;
    public Button rankList;
    public Button admin;
    public Button quit;



    //Getsion du clic en fonction de la source de l'id
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == game)
        {
            redirect("Game");
        }
        else if (event.getSource() == rankList)
        {
            redirect("Ranklist");
        }
        else if (event.getSource() == admin)
        {
            redirect("Admin");
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

    private void redirect(String view) throws IOException {
        Stage stage = (Stage) game.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/"+view+"View.fxml")); // /View/MenuView.fxml
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    // gGgGgG
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
