/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sanam
 */
public class sqlQ {
    
     public static void CreateAcc(String username, String name, String password) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst;
        String query = "INSERT INTO userlogin (name, username, password) VALUES (?, ?, ?)";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Account acount create successful");
        } catch (SQLException e) {
            System.out.println(e);
           JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    public static ResultSet checkuser(String username, String Password) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst;
        ResultSet rs = null;
        String query = "SELECT username, password FROM userlogin WHERE username = ? AND password = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, Password);
            rs = pst.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println(e);   
        }

    return rs;
    }

    public static ResultSet loadtable(String tdname) {
      
             PreparedStatement pst;
        ResultSet rs = null;
       Connection conn = DBConnection.connect();
        

        String query = "SELECT * FROM " + tdname + "";

        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            return rs;
        }
    
    }
     
      public static void delete(String phoneNo,String tdname) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            
            String query = "delete from " + tdname + " where Number = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, phoneNo);
            pst.executeUpdate();
            System.out.println(phoneNo+" "+phoneNo);
           JOptionPane.showMessageDialog(null, "Delete successful");
        } catch (SQLException e) {
            System.out.println(e);
            
             JOptionPane.showMessageDialog(null, "Delete failed", "Error", JOptionPane.ERROR_MESSAGE);

        }
    
    }


      
      

    
    public static void submitData(String firstName, String lastName, String city, String number, String year,String tdname) {
          Connection conn = DBConnection.connect();
        PreparedStatement pst = null;
       String query = "INSERT INTO " + tdname + " (First_name, Last_name, city, Number, Year) VALUES (?, ?, ?, ?, ?)";

        System.out.println(tdname);
        try {
            System.out.println("in try ");
            pst = conn.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, city);
            pst.setString(4, number);
            pst.setString(5, year);
            pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Add successful");
        } catch (SQLException e) {
            System.out.println("in catch");
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

   public static void Update(String name1, String last1, String city1, String number1, String year1, int ID, String tdname) {
    Connection conn = DBConnection.connect();
    PreparedStatement pst = null;

    try {
        String query = "UPDATE "+ tdname +" SET First_name = ?, Last_name = ?, city = ?, Number = ?, Year = ? WHERE id = ?";
        pst = conn.prepareStatement(query);
        pst.setString(1, name1);
        pst.setString(2, last1);
        pst.setString(3, city1);
        pst.setString(4, number1);
        pst.setString(5, year1);
        pst.setInt(6, ID);

        pst.executeUpdate();
      
        
    } catch (SQLException e) {
        System.out.println(e);
        

    }
   }
}




