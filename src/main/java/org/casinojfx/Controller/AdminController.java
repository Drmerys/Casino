package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML private Button quit;
    @FXML private Button back;
    @FXML private TableView table;
    @FXML private TableColumn player;
    @FXML private TableColumn password;
    @FXML private TableColumn birthday;
    @FXML private Button disconnect;
    @FXML private Button update;
    @FXML private Button delete;
    @FXML private Button add;

    // gGgGgG

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
        else if (event.getSource() == update)
        {
            redirect("Update");
        }
        else if (event.getSource() == delete)
        {
            // Observable : Mise à jour de l'interface
            //redirect("Delete");
        }
        else if (event.getSource() == add)
        {
            redirect("Add");
        }
        else if (event.getSource() == quit)
        {
            System.exit(0);
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
