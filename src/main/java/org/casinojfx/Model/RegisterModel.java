package org.casinojfx.Model;

import java.sql.*;

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
        query = "INSERT INTO player (username,password,birthday) " +
                "VALUES('"+user+"','"+password+"', "+birthday+")";
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

    /*public boolean getUserRegistered(String user)
    {
        //query = "SELECT USERNAME FROM PLAYER;";
        try (Statement statement = connect.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT USERNAME FROM PLAYER;");
            if (resultSet != null)
            {
                while (resultSet.next())
                {
                    String name = resultSet.getString("USERNAME");
                    if (name == user){
                        System.out.println(user);
                        return true;
                    }
                }
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
    }*/

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
