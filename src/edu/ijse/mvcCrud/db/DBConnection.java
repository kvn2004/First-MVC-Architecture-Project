/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.db;

import java.sql.*;

/**
 *
 * @author KVN2004
 */
public class DBConnection {

    private Connection connection;
    private static DBConnection dBConnection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "kvn2004");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
