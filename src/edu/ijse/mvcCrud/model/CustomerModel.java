/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.model;

import edu.ijse.mvcCrud.db.DBConnection;
import edu.ijse.mvcCrud.dto.CustomerDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KVN2004
 */
public class CustomerModel {

    public int saveCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, customerDTO.getId());
        stm.setString(2, customerDTO.getTitle());
        stm.setString(3, customerDTO.getName());
        stm.setString(4, customerDTO.getDob());
        stm.setString(5, customerDTO.getSalary() + "");
        stm.setString(6, customerDTO.getAddress());
        stm.setString(7, customerDTO.getCity());
        stm.setString(8, customerDTO.getProvince());
        stm.setString(9, customerDTO.getPostalCode());

        return stm.executeUpdate();

    }

    public int updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";

        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(9, customerDTO.getId());
        stm.setString(1, customerDTO.getTitle());
        stm.setString(2, customerDTO.getName());
        stm.setString(3, customerDTO.getDob());
        stm.setString(4, customerDTO.getSalary() + "");
        stm.setString(5, customerDTO.getAddress());
        stm.setString(6, customerDTO.getCity());
        stm.setString(7, customerDTO.getProvince());
        stm.setString(8, customerDTO.getPostalCode());

        return stm.executeUpdate();

    }

    public int deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE CustID = ?";

        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);

        return stm.executeUpdate();

    }

    public CustomerDTO searchCustomer(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);

        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            CustomerDTO dto = new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5),
                    rst.getString(6), rst.getString(7),
                    rst.getString(8), rst.getDouble(9)
            );

            return dto;
        }

        return null;
    }

    public List<CustomerDTO> getAllCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        List<CustomerDTO> customerDtos = new ArrayList<>();

        ResultSet rst = statement.executeQuery();
        while (rst.next()) {
            CustomerDTO dto = new CustomerDTO(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode"),
                    rst.getString("DOB"),
                    rst.getDouble("salary")
            );
            customerDtos.add(dto);
        }

        return customerDtos;
    }

}
