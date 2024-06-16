/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlQ;
import javax.swing.JOptionPane;
import views.Login;
import views.singup;

/**
 *
 * @author sanam
 */
public class AccCre {

    public void createAccount(String Name, String Email, String Password) {
        if(!Name.equals("")&&!Email.equals("")&&!Password.equals("")){
            sqlQ.CreateAcc(Name, Email, Password);
            
             Login l = new Login();
             l.setVisible(true);
        }
       else {
            singup s = new singup();
            s.setVisible(true);
             JOptionPane.showMessageDialog(null, "Some thing went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
