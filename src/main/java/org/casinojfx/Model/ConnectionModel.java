package org.casinojfx.Model;

import javafx.scene.control.Alert;

import java.sql.*;


public class ConnectionModel {
    private Connection connection;
    private String query;
    private String user;
    private String password;
    private String url;

    public ConnectionModel(Connection connection, String url){
        this.connection = connection;
        this.url = url;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean connect(String usr, String pw){
        query = "SELECT USERNAME, PASSWORD FROM PLAYER " + "WHERE USERNAME = '"+usr+ "' AND PASSWORD = '" +pw+ "'";
        try (Statement state = connection.createStatement(); ResultSet result = state.executeQuery(query))
        {
            if (result.next())
            {
                user = result.getString("username");
                password = result.getString("password");

                connection = DriverManager.getConnection(url);
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Erreur d'accès au serveur ! ");
            error.setHeaderText("La base de données est inaccessible !");
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard !");
            error.showAndWait();
            e.printStackTrace();
            return false;
        }
    }
}
