/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.model;

import edu.ijse.mvcCrud.db.DBConnection;
import edu.ijse.mvcCrud.dto.CustomerDTO;
import java.sql.*;

/**
 *
 * @author KVN2004
 */
public class CustomerModel {

    public int saveCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm= connection.prepareStatement(sql);

        stm.set(customerDTO.getId(), 1);
        connection.prepareStatement(customerDTO.getTitle(), 2);
        connection.prepareStatement(customerDTO.getName(), 3);
        connection.prepareStatement(customerDTO.getDob(), 4);
        connection.prepareStatement(customerDTO.getSalary() + "", 5);
        connection.prepareStatement(customerDTO.getAddress(), 6);
        connection.prepareStatement(customerDTO.getCity(), 7);
        connection.prepareStatement(customerDTO.getProvince(), 8);
        connection.prepareStatement(customerDTO.getPostalCode(), 9);
        
        stm.executeUpdate();

        return 0;

    }

}
