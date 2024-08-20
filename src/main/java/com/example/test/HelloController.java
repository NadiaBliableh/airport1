
package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.postgresql.Driver;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField ID_test;

    @FXML
    private TextField name_test;

    @FXML
    protected void onclick() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/postgres";
            con = DriverManager.getConnection(conInfo, "nadia", "987410");
            con.setAutoCommit(false);

            String qry = "INSERT INTO airport.my_table (\"id\", \"name\") VALUES (?, ?)";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_test.getText()));
            pstmt.setString(2, name_test.getText());

            int rowsAffected = pstmt.executeUpdate();
            con.commit(); // Commit the transaction

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog((Component)null, "Data inserted successfully!");
            } else {
                JOptionPane.showMessageDialog((Component)null, "Insertion failed.");
            }
        } catch (SQLException var16) {
            JOptionPane.showMessageDialog((Component)null, "SQL Error: " + var16.getMessage());
            if (con != null) {
                con.rollback(); // Rollback the transaction on error
            }
        } catch (Exception var17) {
            JOptionPane.showMessageDialog((Component)null, "Error: " + var17.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException var15) {
                JOptionPane.showMessageDialog((Component)null, "Error closing resources: " + var15.getMessage());
            }
        }
    }



    /*
    @FXML
    protected void onclick() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/postgres";
            con = DriverManager.getConnection(conInfo, "nadia", "987410");
            con.setAutoCommit(false);

            // Assuming the my_table has columns that can take these text values
            String qry = "INSERT INTO airport.my_table (\"id\", \"name\") VALUES (?, ?)";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_test.getText()));
            pstmt.setString(2, name_test.getText());



            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog((Component)null, "Data inserted successfully!");
            } else {
                JOptionPane.showMessageDialog((Component)null, "Insertion failed.");
            }
        } catch (SQLException var16) {
            JOptionPane.showMessageDialog((Component)null, "SQL Error: " + var16.getMessage());
        } catch (Exception var17) {
            JOptionPane.showMessageDialog((Component)null, "Error: " + var17.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException var15) {
                JOptionPane.showMessageDialog((Component)null, "Error closing resources: " + var15.getMessage());
            }
        }
    }
    */




}
















/*package com.example.test;

import java.awt.Frame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Component;
import java.sql.PreparedStatement;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.postgresql.Driver;





public class HelloController {


    @FXML
    private TextField  ID_test;


    @FXML
    private TextField  name_text;





    @FXML
    protected void onclick() throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

            try {

                DriverManager.registerDriver(new Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/postgres";
            con=  DriverManager.getConnection(conInfo,"nadia","987410");
            con.setAutoCommit(false);

            String qry ="insert into my_table values("+this.ID_test.getText()+","+this.name_text.getText()+")";



               // String qry = "INSERT INTO my_table (\"New\") VALUES (?)";
            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(this.ID_test.getText()));
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog((Component)null, "Data inserted successfully!");
            } else {
                JOptionPane.showMessageDialog((Component)null, "Insertion failed.");
            }
        } catch (SQLException var16) {
            SQLException e = var16;
            JOptionPane.showMessageDialog((Component)null, "SQL Error: " + e.getMessage());
        } catch (Exception var17) {
            Exception e = var17;
            JOptionPane.showMessageDialog((Component)null, "Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException var15) {
                SQLException e = var15;
                JOptionPane.showMessageDialog((Component)null, "Error closing resources: " + e.getMessage());
            }

        }


/*

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String connInfo="jdbc:postgresql://locahost:5432/postgres";
            Connection con=  DriverManager.getConnection(connInfo,"nadia","987410");
            con.setAutoCommit(false);
            String qry ="insert into my_table values("+this.IDtest.getText()+","+this.nametext.getText()+")";

            Statement stmt= con.createStatement();
            stmt.executeUpdate(qry);
            con.commit();
            con.close();
            JOptionPane.showConfirmDialog(null,"Successfully added");;




        } catch (Exception e) {
            //throw new RuntimeException(e);
            JOptionPane.showConfirmDialog(null,e.toString());;
        }



    }
}


 */



