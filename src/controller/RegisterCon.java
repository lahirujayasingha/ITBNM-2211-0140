/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlQ;
import javax.swing.JTextField;

/**
 *
 * @author senvi
 */
public class RegisterCon {

    public void submitdata(JTextField fname, JTextField lname, JTextField city, JTextField pno, JTextField year, String tdname) {
     String Fname = fname.getText();
     String Lname = lname.getText();
     String City = city.getText();
     String Pno = pno.getText();
     String Year = year.getText();
     sqlQ.submitData(Fname, Lname, City, Lname, Year, tdname);
  
    }

 

   
    
}
