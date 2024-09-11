/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.controller;

import edu.ijse.mvcCrud.dto.CustomerDTO;
import edu.ijse.mvcCrud.model.CustomerModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KVN2004
 */
public class CustomerController {

    private CustomerModel customerModel = new CustomerModel();

    public int saveCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return customerModel.saveCustomer(customerDTO);
    }

    public int updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return customerModel.updateCustomer(customerDTO);
    }

    public int deleteCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return customerModel.updateCustomer(customerDTO);
    }

    public CustomerDTO searchCustomer(String customerId) throws Exception {

        return customerModel.searchCustomer(customerId);
    }

    public List<CustomerDTO> getAllCustomer() throws Exception {

        return customerModel.getAllCustomer();
    }
}
