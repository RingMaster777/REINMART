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
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class HomePageController implements Initializable {

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
    private Button cart;

    @FXML
    private Label lasttime1;

    @FXML
    private Button txt1button;

    @FXML
    private TextField txt1;

    @FXML
    private Label cbid1;

    @FXML
    private Button buybutton1;

    @FXML
    private Label cprice1;

    @FXML
    private Label prodes1;

    @FXML
    private Button txt3button;

    @FXML
    private TextField txt3;

    @FXML
    private Button buybutton3;

    @FXML
    private Label prodes3;

    @FXML
    private Label lasttime3;

    @FXML
    private Label cprice3;

    @FXML
    private Label cbid3;

    @FXML
    private Button txt4button;

    @FXML
    private TextField txt4;

    @FXML
    private Button buybutton4;

    @FXML
    private Label prodes4;

    @FXML
    private Label lasttime4;

    @FXML
    private Label cbid4;

    @FXML
    private Label cprice4;

    @FXML
    private Button txt5button;

    @FXML
    private TextField txt5;

    @FXML
    private Label cprice5;

    @FXML
    private Button buybutton5;

    @FXML
    private Label prodes5;

    @FXML
    private Label lasttime5;

    @FXML
    private Label cbid5;

    @FXML
    private Button txt6button;

    @FXML
    private TextField txt6;

    @FXML
    private Label cprice6;

    @FXML
    private Button buybutton6;

    @FXML
    private Label prodes6;

    @FXML
    private Label lasttime6;

    @FXML
    private Label cbid6;

    @FXML
    private Button txt2button;

    @FXML
    private TextField txt2;

    @FXML
    private Label label2;

    @FXML
    private Button buybutton2;

    @FXML
    private Label prodes2;

    @FXML
    private Label cprice2;

    @FXML
    private Label cbid2;

    @FXML
    private Label lasttime2;

    //new
    @FXML
    private Label hb1;
    @FXML
    private Label hb2;
    @FXML
    private Label hb3;
    @FXML
    private Label hb4;
    @FXML
    private Label hb5;
    @FXML
    private Label hb6;

    @FXML
    private Label showuname;

    public String l;
    public String check;
    public String sprice;

    public int bidtimercheck;

    /**
     * Initializes the controller class.
     */
    private Connection connection;
    private DBHandler handler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showuname.setText("**Welcome " + LogInController.myname + "**");
            showproductdetails(1, cprice1, prodes1, cbid1, lasttime1, hb1);
            showproductdetails(2, cprice2, prodes2, cbid2, lasttime2, hb2);
            showproductdetails(3, cprice3, prodes3, cbid3, lasttime3, hb3);
            showproductdetails(4, cprice4, prodes4, cbid4, lasttime4, hb4);
            showproductdetails(5, cprice5, prodes5, cbid5, lasttime5, hb5);
            showproductdetails(6, cprice6, prodes6, cbid6, lasttime6, hb6);
            //// TODO
        } catch (SQLException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void exitaction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void homeaction(ActionEvent event) {

    }

    @FXML
    void contactusaction(ActionEvent event) {
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
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void aboutus(ActionEvent event) {

        try {
            aboutus.getScene().getWindow().hide();
            Stage aboutUs = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/AboutUs.fxml"));
            Scene scene = new Scene(root);
            aboutUs.setTitle("REIN MART");
            aboutUs.setScene(scene);
            aboutUs.show();
            aboutUs.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void cartaction(ActionEvent event) {
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

    // the bid button action
    @FXML
    void txt1buttonacton(ActionEvent event) throws SQLException, ParseException {

        if (remainingtimeshow(1)) {

            sprice = cprice1.getText();
            l = txt1.getText();
            check = cbid1.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt1.setText("");
                    txt1.requestFocus();
                } else {
                    biddingupdate(l, 1, cbid1, hb1);
                    txt1.setText("");
                    txt1.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt1.setText("");
                txt1.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt1.setText("");
            txt1.requestFocus();
        }
    }

    @FXML
    void txt2buttonaction(ActionEvent event) throws SQLException, ParseException {

        if (remainingtimeshow(2)) {

            sprice = cprice2.getText();
            l = txt2.getText();
            check = cbid2.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt2.setText("");
                    txt2.requestFocus();
                } else {
                    biddingupdate(l, 2, cbid2, hb2);
                    txt2.setText("");
                    txt2.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt2.setText("");
                txt2.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt2.setText("");
            txt2.requestFocus();
        }
    }

    @FXML
    void txt3buttonaction(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(3)) {

            sprice = cprice3.getText();
            l = txt3.getText();
            check = cbid3.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt3.setText("");
                    txt3.requestFocus();
                } else {
                    biddingupdate(l, 3, cbid3, hb3);
                    txt3.setText("");
                    txt3.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt3.setText("");
                txt3.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt3.setText("");
            txt3.requestFocus();
        }
    }

    @FXML
    void txt4buttonaction(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(4)) {

            sprice = cprice4.getText();
            l = txt4.getText();
            check = cbid4.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt4.setText("");
                    txt4.requestFocus();
                } else {
                    biddingupdate(l, 4, cbid4, hb4);
                    txt4.setText("");
                    txt4.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt4.setText("");
                txt4.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt4.setText("");
            txt4.requestFocus();
        }
    }

    @FXML
    void txt5button(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(5)) {

            sprice = cprice5.getText();
            l = txt5.getText();
            check = cbid5.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt5.setText("");
                    txt5.requestFocus();
                } else {
                    biddingupdate(l, 5, cbid5, hb5);
                    txt5.setText("");
                    txt5.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt5.setText("");
                txt5.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt5.setText("");
            txt5.requestFocus();
        }
    }

    @FXML
    void txt6buttonaction(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(6)) {

            sprice = cprice6.getText();
            l = txt6.getText();
            check = cbid6.getText();
            if (Float.parseFloat(sprice) < Float.parseFloat(l)) {
                if (Float.parseFloat(check) >= Float.parseFloat(l)) {
                    JOptionPane.showMessageDialog(null, "Invalid Bid");
                    txt6.setText("");
                    txt6.requestFocus();
                } else {
                    biddingupdate(l, 6, cbid6, hb6);
                    txt6.setText("");
                    txt6.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Your bid should be higher than starting price");
                txt6.setText("");
                txt6.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bidding time is over");
            txt6.setText("");
            txt6.requestFocus();
        }
    }
    // the  bid buttons action ends

    // for the buy buttons to execute
    @FXML
    void buybutton1action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(1)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");

        } else {
            buybuttonoperationgenerator(1);
        }

    }

    @FXML
    void buybutton2action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(2)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");
        } else {
            buybuttonoperationgenerator(2);
        }

    }

    @FXML
    void buybutton3action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(3)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");

        } else {
            buybuttonoperationgenerator(3);
        }

    }

    @FXML
    void buybutton4action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(4)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");

        } else {
            buybuttonoperationgenerator(4);
        }

    }

    @FXML
    void buybutton5action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(5)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");
        } else {
            buybuttonoperationgenerator(5);
        }

    }

    @FXML
    void buybutton6action(ActionEvent event) throws SQLException, ParseException {
        if (remainingtimeshow(6)) {
            JOptionPane.showMessageDialog(null, "You can not buy while bid is running");
        } else {
            buybuttonoperationgenerator(6);
        }

    }
    // buy buttons execution ends

    // to update the users bid  
    void biddingupdate(String mybid, int productid, Label l1, Label l2) throws SQLException, ParseException {

        float bid = Float.parseFloat(mybid);
        String amount = null;
        String hb = null;

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinmart", "root", "");
        String st = "SELECT  `name` FROM `signin` WHERE ID = " + LogInController.i;
        Statement s = conn.createStatement();
        ResultSet ps = s.executeQuery(st);
        String name = "";

        if (ps.next()) {
            name = ps.getString("name");

        }

        String insert = "UPDATE `products` SET `highest_bid`= " + bid + ",`bider` = \"" + name + "\" WHERE product_ID = " + productid;
        Statement pst1 = conn.createStatement();
        pst1.executeUpdate(insert);

        String str = "SELECT  `highest_bid`, `bider` FROM `products` WHERE product_ID = " + productid;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(str);
        if (rs.next()) {
            amount = rs.getString("highest_bid");
            hb = rs.getString("bider");
        }
        l1.setText(amount);
        l2.setText("Bidder: " + hb);

    }
    // to update userbid ends

    // bid timer execution
    boolean remainingtimeshow(int productid) throws SQLException, ParseException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinmart", "root", "");
        String st2 = "SELECT  `Bidding_date`, `Bidding_time` FROM `products` WHERE product_ID = " + productid;
        Statement s2 = conn.createStatement();
        ResultSet rs2 = s2.executeQuery(st2);
        String date = "";
        String time = "";

        if (rs2.next()) {
            date = rs2.getDate("Bidding_date").toString();
            time = rs2.getTime("Bidding_time").toString();
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        long lng = passedTime(format.parse(date + time), new Date());
        if (lng <= 0) {
            return false;
        } else {
            return true;
        }
    }
    // bid timer execution ends

    // to show product details
    void showproductdetails(int productid, Label l1, Label l2, Label l3, Label l4, Label l5) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinmart", "root", "");
        String st2 = "SELECT `Product_price`, `Product_description`, `highest_bid`, `Bidding_date`, `Bidding_time`, `bider` FROM `products` WHERE product_ID = " + productid;
        Statement s2 = conn.createStatement();
        ResultSet rs2 = s2.executeQuery(st2);
        String productprice = "";
        String productdescription = "";
        String highestbid = "";
        String date = "";
        String time = "";
        String highestbider = "";

        if (rs2.next()) {
            productprice = rs2.getString("Product_price");
            productdescription = rs2.getString("Product_description");
            highestbid = rs2.getString("highest_bid");
            date = rs2.getDate("Bidding_date").toString();
            time = rs2.getTime("Bidding_time").toString();
            highestbider = rs2.getString("bider");
        }
        l1.setText(productprice);
        l2.setText(productdescription);
        l3.setText(highestbid);
        l4.setText(date + "  " + time);
        l5.setText("Bidder: " + highestbider);

    }
    // to show product details ends

    // for the buy button execution method
    void buybuttonoperationgenerator(int productid) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinmart", "root", "");
        String sst = "SELECT `bider` FROM `products` WHERE product_ID = " + productid;
        Statement s = conn.createStatement();
        ResultSet ps = s.executeQuery(sst);
        String productbidder = "";

        if (ps.next()) {
            productbidder = ps.getString("bider");

        }
        String stt = "SELECT `name` FROM `signin` WHERE ID = " + LogInController.i;
        Statement sr = conn.createStatement();
        ResultSet pls = sr.executeQuery(stt);
        String currentuser = "";

        if (pls.next()) {
            currentuser = pls.getString("name");
        }

        if (productbidder.equals(" " + currentuser)) {
            JOptionPane.showMessageDialog(null, "You have successfully bought this product!");
            // update sold to column

            String st3 = "UPDATE `products` SET `product_soldTo` = '" + currentuser + "' WHERE product_ID = " + productid;
            Statement so = conn.createStatement();
            so.executeUpdate(st3);
            System.out.println(currentuser);
            System.out.println(productbidder);

        } else {
            JOptionPane.showMessageDialog(null, "You are not elligible to buy this product!");
        }

    }
    // for the buy button execution method ends

    // for converting time into millisecocnd
    public long passedTime(Date currentDate, Date postDate) {
        long text;
        long mSecPerMinute = 60 * 1000;//milli
        long mSecPerHour = mSecPerMinute * 60;
        long mSecPerDay = mSecPerHour * 24;
        long mSecPerMonth = mSecPerDay * 30;
        long mSecPerYear = mSecPerDay * 365;
        long diff = currentDate.getTime() - postDate.getTime();

        if (diff < mSecPerMinute)//seconds ago
        {
            if (Math.round(diff / 1000) == 1) {
                text = (Math.round(diff / 1000));
            } else {
                text = (Math.round(diff / 1000));
            }
        } else if (diff < mSecPerHour)//min ago
        {
            if (Math.round(diff / mSecPerMinute) == 1) {
                text = (Math.round(diff / mSecPerMinute));
            } else {
                text = (Math.round(diff / mSecPerMinute));
            }
        } else if (diff < mSecPerDay)//hours
        {
            if (Math.round(diff / mSecPerHour) == 1) {
                text = (Math.round(diff / mSecPerHour));
            } else {
                text = (Math.round(diff / mSecPerHour));
            }
        } else if (diff < mSecPerMonth)//day
        {
            if (Math.round(diff / mSecPerDay) == 1) {
                text = (Math.round(diff / mSecPerDay));
            } else {
                text = (Math.round(diff / mSecPerDay));
            }
        } else if (diff < mSecPerYear)//month
        {
            if (Math.round(diff / mSecPerMonth) == 1) {
                text = (Math.round(diff / mSecPerMonth));
            } else {
                text = (Math.round(diff / mSecPerMonth));
            }

        } else { //year
            if (Math.round(diff / mSecPerYear) == 1) {
                text = (Math.round(diff / mSecPerYear));
            } else {
                text = (Math.round(diff / mSecPerYear));
            }

        }
        return text;
    }
    // for converting time into millisecocnd ends

}
