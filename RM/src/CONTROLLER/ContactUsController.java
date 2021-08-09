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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ContactUsController implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Button exit;
    @FXML
    private Button home;
    @FXML
    private Button aboutus;
    @FXML
    private Button cart;
    
    @FXML
    private Label showuname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showuname.setText("**Welcome "+LogInController.myname+"**");
        // TODO
    }    

    @FXML
    private void logoutaction(ActionEvent event) {
        try {
            logout.getScene().getWindow().hide();
            Stage logIn = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/LogIn.fxml"));
            Scene scene = new Scene(root);
            logIn.setTitle("REIN MART");
            logIn.setScene(scene);
            logIn.show();
            logIn.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(ContactUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cartaction(ActionEvent event) {
        try {
            cart.getScene().getWindow().hide();
            Stage cartinterface = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Cart.fxml"));
            Scene scene = new Scene(root);
            cartinterface.setTitle("REIN MART");
            cartinterface.setScene(scene);
            cartinterface.show();
            cartinterface.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(AboutUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitaction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void homeaction(ActionEvent event) {
        try {
            home.getScene().getWindow().hide();
            Stage homeinterface = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
            Scene scene = new Scene(root);
            homeinterface.setTitle("REIN MART");
            homeinterface.setScene(scene);
            homeinterface.show();
            homeinterface.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(ContactUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aboutusaction(ActionEvent event) {
        
        try {
            aboutus.getScene().getWindow().hide();
            Stage aboutusinterface = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/AboutUs.fxml"));
            Scene scene = new Scene(root);
            aboutusinterface.setTitle("REIN MART");
            aboutusinterface.setScene(scene);
            aboutusinterface.show();
            aboutusinterface.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(ContactUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


