/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlQ;
import javax.swing.JOptionPane;
import views.singup;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.Login;
import views.home;

/**
 *
 * @author sanam
 */
public class loginControler {

    public void checkuser(String username, String Password){
         if(!username.equals("")&&!Password.equals("")){
           ResultSet a =  sqlQ.checkuser(username, Password);
           try{
           if(a.next()){
            String email = a.getString("username");
            String password = a.getString("password");
            if(email.equals(username) && password.equals(Password)){
             home h = new home();
             h.setVisible(true);
        
            }
           
            
              
           }
            else{
                
             Login s = new Login();
            s.setVisible(true);
             JOptionPane.showMessageDialog(null, "Some thing went wrong", "Error", JOptionPane.ERROR_MESSAGE);
    
            }
              } catch (SQLException e) {
                  System.out.println(e);

        }
           
           
           }
        
       else {
            Login s = new Login();
            s.setVisible(true);
             JOptionPane.showMessageDialog(null, "enter user name or passwsord", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
      
    
    }
}
    
    

