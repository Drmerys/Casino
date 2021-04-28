package org.casinojfx.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterModel {
    private Connection connect;
    private String user;
    private String password;
    private String confirmation;
    private String birthday;
    private String query;
    private String url;

    public RegisterModel(Connection connect, String url){
        this.connect = connect;
        this.url = url;
    }

    public boolean insertUser(){
        query = "INSERT INTO PLAYER (USERNAME,PASSWORD,BIRTHDAY)" +
                "VALUES('"+user+"', '"+password+"', "+birthday+")";

        System.out.println(query);

        try (Statement state = connect.createStatement())
        {
            int result = state.executeUpdate(query);
                if (result > 0){
                    return true;
                }
                else
                {
                    return false;
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signUp(){
        //Connection connect = DataBaseConnectionModel.getInstance();
        query = "INSERT INTO player (username,password,birthday) " +
                "VALUES('" + user + "','" + password + "','" + birthday + "')";
        try {
            Statement statement = connect.createStatement();

            int status = statement.executeUpdate(query);
                if (status > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getUserRegistered(String user)
    {
        // Encapsulé en try catch
        //requte
        // si resultat == user
            // return true
        // sinon
            // return false
        return true;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public String getConfirmation()
    {
        return confirmation;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(String birthday) {
        this.birthday = (birthday != null) ? "'" + birthday + "'":null;
    }

    // Réinitialisation du modèle
    public void clean(){
        this.user = null;
        this.password = null;
        this.birthday = null;
        this.confirmation = null;
    }

}
