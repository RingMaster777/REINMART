/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// code
package rm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */


public class RM extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource( "/FXML/LogIn.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(RM.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("REIN MART");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}
