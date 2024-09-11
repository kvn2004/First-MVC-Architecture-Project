/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ijse.mvcCrud;

import edu.ijse.mvcCrud.db.DBConnection;
import edu.ijse.mvcCrud.view.CustomerView;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author KVN2004
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        CustomerView customerView = new CustomerView();
        customerView.setVisible(true);
        customerView.setLocationRelativeTo(null);

    }

}
