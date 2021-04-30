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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RanklistController implements Initializable {
    public TextField scoreField;
    public TextField playerField;
    @FXML private Button disconnect;
    @FXML private Button back;
    @FXML private Button quit;
    @FXML private TableView table;
    @FXML private TableColumn player;
    @FXML private TableColumn score;
    @FXML private Button addPlayerRank;

    // gGgGgG

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == back)
        {
            redirect("Menu");
        }
        else if (event.getSource() == addPlayerRank)
        {
            redirect("AddPlayerRank");
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

    public void redirect(String view) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/"+view+"View.fxml")); // /View/MenuView.fxml
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleOk(ActionEvent event) {
    }

    public void handleCancel(ActionEvent event) {
    }
}
