package org.casinojfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Démarrage de l'application
public class Casino extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        /*stage.setTitle("Test !");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setResizable(true);
        stage.show();
        stage.centerOnScreen();*/

        Parent root  = FXMLLoader.load(getClass().getResource("/View/authentification.fxml"));

        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Casino en ligne");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args){
        System.out.println("Application started ! ");
        Application.launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application stopped ! ");
    }
}
