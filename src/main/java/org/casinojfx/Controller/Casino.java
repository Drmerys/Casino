package org.casinojfx.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Démarrage de l'application
public class Casino extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root  = FXMLLoader.load(getClass().getResource("/View/ConnectionView.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Casino en ligne");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Application started ! ");
        Application.launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application stopped ! ");
    }
}
