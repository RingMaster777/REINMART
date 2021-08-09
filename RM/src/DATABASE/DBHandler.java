/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class DBHandler extends config {

    Connection dbconnection;

    public Connection getConnection() {
        String connectionstring = "jdbc:mysql://" + config.dbhost + ":" + config.dbport + "/" + config.dbname;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbconnection = DriverManager.getConnection(connectionstring, config.dbuser, config.dbpass);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dbconnection;

    }

}
