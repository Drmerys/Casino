package org.casinojfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.casinojfx.Model.DataBaseConnectionModel;
import org.casinojfx.Model.RegisterModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML private Label msgError;
    @FXML private Button quit;
    @FXML private TextField user;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmation;
    @FXML private DatePicker birthday;
    @FXML private Button register;
    @FXML private Button connection;
    private DataBaseConnectionModel dataBaseConnectionModel;
    private RegisterModel registerModel;


    //Gestion du clavier, pour qu'on puisse se connecter en appuyant sur Enter
    @FXML
    public void handleKeyPress(KeyEvent keyEvent) throws IOException{
        if (keyEvent.getCode() == KeyCode.ENTER){
            register();
        }
    }

    // Gestion du clic
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException{
        if (event.getSource() == register)
        { // Insertion de l'utilisateur
            dataBaseConnectionModel = DataBaseConnectionModel.getInstance();
            dataBaseConnectionModel.setConnection();
            registerModel = dataBaseConnectionModel.getRegisterModel();
            if (registerModel.getUserRegistered(user.getText()))
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Inscription echoué !");
                error.setHeaderText("Nom de joueur existant !");
                error.setContentText("Le nom " +user.getText()+ " n'est pas disponible, veuillez choisir un autre !");
            }
            else
            {
                register();
            }
        }
        else if (event.getSource() == connection)
        {
            Stage stage = (Stage) connection.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/View/ConnectionView.fxml"));
            Scene scene = new Scene(root);
            //stage.setResizable(true);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
        else if (event.getSource() == quit)
        {
            System.exit(0);
        }
    }

    public void register() throws IOException {
        if (user.getText().length() >= 6 && password.getText().length() >= 6 && confirmation.getText().length() >= 6)
        {
            if (password.getText().equals(confirmation.getText()))
            {
                boolean userValue = (user.getText() != null);
                boolean passwordValue = (password.getText() != null);
                boolean birthdayValue = (birthday.getValue() != null);
                if (userValue && passwordValue && birthdayValue)
                {
                    dataBaseConnectionModel = DataBaseConnectionModel.getInstance();
                    dataBaseConnectionModel.setConnection();
                    registerModel = dataBaseConnectionModel.getRegisterModel();

                    registerModel.setUser(user.getText());
                    registerModel.setPassword(password.getText());
                    registerModel.setBirthday(birthday.getValue().toString());

                    if (registerModel.insertUser())
                    {
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Inscription réussi !");
                        success.setHeaderText("Ajout du joueur ! ");
                        success.setContentText("Le joueur a bien été enregistré");
                        success.showAndWait();
                        registerModel.clean();

                        Stage stage = (Stage) register.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("/View/ConnectionView.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        //stage.setResizable(true);
                        stage.show();
                        stage.centerOnScreen();
                    }
                    else
                    {
                        Alert error = new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Inscription echoué !");
                        error.setHeaderText("Le joueur n'a pas été ajouté !");
                        error.setContentText("Une érreur a été rencontré et le joueur n'a pas été enregistré !");
                    }
                }
                else
                {
                    msgError.setText("Les champs sont obligatoire ! ");
                }
            }
            else
            {
                msgError.setText("Les mots de passe ne sont pas identique ! ");
            }
        }
        else
        {
            if (user.getText().length() < 6)
            {
                msgError.setText("le nom d'utilisateur requières au moins 6 caractères ! ");
            }
            else if (password.getText().length() < 6)
            {
                msgError.setText("Le mot de passe requières au moins 6 caractères ! ");
            }
            else if (confirmation.getText().length() < 6)
            {
                msgError.setText("La confirmation requières au moins 6 caractères ! ");
            }
            /*else
            {
                msgError.setText("Tous les champs requières au moins 6 caractères ! ");
            }*/
        }
    }

    // Initialisation du contrôleur
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        /*dataBaseConnectionModel = DataBaseConnectionModel.getInstance();
        registerModel = dataBaseConnectionModel.getRegisterModel();

        // Affectation des valeurs au champs
        user.setText(registerModel.getUser());
        password.setText(registerModel.getPassword());
        if (registerModel.getBirthday() != null)
        {
            birthday.setValue(LocalDate.parse(registerModel.getBirthday(), DateTimeFormatter.ISO_DATE));
        }*/
    }
}
