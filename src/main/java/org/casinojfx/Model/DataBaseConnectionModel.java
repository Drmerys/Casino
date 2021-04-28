package org.casinojfx.Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DataBaseConnectionModel {

    private static DataBaseConnectionModel dataBaseConnectionModel; //Single
    private Connection connection;
    private String url = "jdbc:sqlite:src/main/resources/Model/casino.db";
    private String user;
    private String password;
    private RegisterModel registerModel;
    private ConnectionModel connectionModel;

    private DataBaseConnectionModel(){
        try {
            /*Chargement du pilote*/
            Class.forName("org.sqlite.JDBC");
            System.out.println("Pilote chargé");

            // Connexion à la bdd et instanciation de la fenêtre de connexion
            this.connection = DriverManager.getConnection(url);
            this.connection.setAutoCommit(false);
            this.connectionModel = new ConnectionModel(connection, url);
            System.out.println("Connexion établie ! ");
        }catch (SQLException e)
        {
            System.err.println("Impossible de se connecter à la base de données !");
            System.exit(0);
        } catch (ClassNotFoundException e)
        {
            System.err.println("Impossible de charger le pilote !");
            System.exit(0);
            e.printStackTrace();
        }
    }

    /**
     * @return Connection
     */
    public static DataBaseConnectionModel getInstance()
    {
        if (dataBaseConnectionModel == null){
            return new DataBaseConnectionModel();
        }

        return  dataBaseConnectionModel;
    }

    public RegisterModel getRegisterModel(){

        return registerModel;
    }

    public ConnectionModel getConnectionModel()
    {
        return connectionModel;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Refait la connexion avec les nouveaux user et mdp récupérés grâce au modèle de connexion
    public void setConnection()
    {
        try
        {
            this.connection = DriverManager.getConnection(url);
            this.registerModel = new RegisterModel(connection, url);
            //this.connectionModel = new ConnectionModel(connection, url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
