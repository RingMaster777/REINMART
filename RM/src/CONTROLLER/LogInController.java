/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import DATABASE.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LogInController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button exit;
    @FXML
    private Button signup;

    public static String myname;
    public static int i;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    private PreparedStatement pst2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        handler = new DBHandler();
    }

    @FXML
    void exitaction(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void loginaction(ActionEvent event) {

        String lusername = username.getText();
        String lpass = password.getText();

        // retriving data
        connection = handler.getConnection();
        String insert = "SELECT * FROM signin WHERE username=? and password=?";
        int count = 0;
        try {
            pst = connection.prepareStatement(insert);
            pst.setString(1, lusername);
            pst.setString(2, lpass);
            ResultSet re = pst.executeQuery();
            if (re.next()) {
                JOptionPane.showMessageDialog(null, "Login succes!");
                count = 1;
                String query = "SELECT `ID`, `name` FROM `signin` WHERE username = \" " + lusername + " \" ";
                pst2 = connection.prepareStatement(query);
                ResultSet re1 = pst.executeQuery();
                while (re1.next()) {
                    //id = re1.getString("ID");
                    myname = re1.getString("name");
                    i = re1.getInt("ID");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!");
                username.setText("");
                password.setText("");
                username.requestFocus();

            }

        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // retriving data ends
        // to show the homepage interface
        if (count == 1) {
            try {
                login.getScene().getWindow().hide();
                Stage homepage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
                Scene scene = new Scene(root);
                homepage.setTitle("REIN MART");
                homepage.setScene(scene);
                homepage.show();
                homepage.setResizable(false);
            } catch (IOException ex) {
                Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void signupaction(ActionEvent event) {

        // to show the sign Up interface
        try {
            signup.getScene().getWindow().hide();
            Stage signUp = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignUp.fxml"));
            Scene scene = new Scene(root);
            signUp.setTitle("REIN MART");
            signUp.setScene(scene);
            signUp.show();
            signUp.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
