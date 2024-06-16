/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlQ;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.OL;

/**
 *
 * @author senvi
 */
public class displayCon {

 public void load(JTable table, String tableName) {
    ResultSet rs = sqlQ.loadtable(tableName);  // Assuming sqlQ.loadTable(String) returns a ResultSet
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);  // Clear existing rows

    try {
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

    public void delete(JTable s5,String tdname) {
       
        int r = s5.getSelectedRow();
        System.out.println(r);
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Select table", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
              String i = s5.getValueAt(r, 3).toString();
          sqlQ.delete(i, tdname);
          load(s5,tdname);

      
        }
        
    }

    public void update(String name1, String last1, String city1, String number1, String year1, int ID, String tdname, JTable AL) {
       sqlQ.Update(name1,last1,city1,number1,year1,ID,tdname);
       
       load(AL,tdname);
  
      
    }

}
