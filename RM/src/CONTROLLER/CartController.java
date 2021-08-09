/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class CartController implements Initializable {

    @FXML
    private Button logout;
    @FXML
    private Button exit;
    @FXML
    private Button home;
    @FXML
    private Button aboutus;
    @FXML
    private Button contactus;
    @FXML
    private Label showuname;

    
    @FXML
    private TableView<ModelTable> protable;
    @FXML
    private TableColumn<ModelTable, String> protableid;
    @FXML
    private TableColumn<ModelTable, String> protablename;
    @FXML
    private TableColumn<ModelTable, String> protableprice;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showuname.setText("**Welcome "+LogInController.myname+"**");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinmart", "root", "");
            String st = "SELECT  `name` FROM `signin` WHERE ID = " + LogInController.i;
            Statement s = conn.createStatement();
            ResultSet ps = s.executeQuery(st);
            String name = "";
            if (ps.next()) {
                name = ps.getString("name");
            }
            
            String query = "SELECT `product_ID`, `Product_description`, `highest_bid` FROM `products` WHERE product_soldTo = \"" + name+"\"";
            Statement s2 = conn.createStatement();
            ResultSet rst = s2.executeQuery(query);
            while(rst.next()){
                oblist.add(new ModelTable(rst.getString("product_ID"),
                        rst.getString("Product_description"),
                        rst.getString("highest_bid")));
                
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        protableid.setCellValueFactory(new PropertyValueFactory<>("productId"));
        protablename.setCellValueFactory(new PropertyValueFactory<>("productName"));
        protableprice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        
        protable.setItems(oblist);
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
            Logger.getLogger(AboutUsController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AboutUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void contactusaction(ActionEvent event) {
        try {
            contactus.getScene().getWindow().hide();
            Stage contactusinterface = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/ContactUs.fxml"));
            Scene scene = new Scene(root);
            contactusinterface.setTitle("REIN MART");
            contactusinterface.setScene(scene);
            contactusinterface.show();
            contactusinterface.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(AboutUsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
