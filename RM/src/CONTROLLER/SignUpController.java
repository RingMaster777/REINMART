/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DATABASE.DBHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField username;

    @FXML
    private PasswordField pass;

    @FXML
    private PasswordField conpass;

    @FXML
    private TextField email;

    @FXML
    private Button signup;

    @FXML
    private Button exit;

    @FXML
    private Button login;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) throws IOException {

        // to show the login interface
        login.getScene().getWindow().hide();
        Stage logIn = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LogIn.fxml"));
        Scene scene = new Scene(root);
        logIn.setTitle("REIN MART");
        logIn.setScene(scene);
        logIn.show();
        logIn.setResizable(false);

    }

    @FXML
    void signUpsave(ActionEvent event) throws SQLException {

        String sname = name.getText();
        String susername = username.getText();
        String semail = email.getText();
        String spass = pass.getText();
        String sconpass = conpass.getText();

        if ((spass.equals("")) || (semail.equals("")) || (sname.equals("")) || (susername.equals("")) || (sconpass.equals(""))) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ALERT");
            alert.setHeaderText(null);
            alert.setContentText("Enter all the information");
            alert.showAndWait();
        } else {
            //saving data
            if ((validateEmail(semail)) && (validatePassword(spass, sconpass))) {
                String insert = "INSERT INTO signin(name, username, email, password)" + "VALUES (?,?,?,?)";
                connection = handler.getConnection();
                pst = connection.prepareStatement(insert);
                pst.setString(1, sname);
                pst.setString(2, susername);
                pst.setString(3, semail);
                pst.setString(4, spass);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sign Up succes!");
            }
        }
    }

    private boolean validateEmail(String se) {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(se);
        if (m.find() && m.group().equals(se)) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ALERT");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid Email");
            alert.showAndWait();
            return false;
        }
    }
    
    
    private boolean validatePassword(String sp, String scp) {
        
        if (sp.equals(scp)) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ALERT");
            alert.setHeaderText(null);
            alert.setContentText("Password fields must be same");
            alert.showAndWait();
            return false;
        }

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        handler = new DBHandler();
    }

}
