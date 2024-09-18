/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.controller;

import edu.ijse.mvcCrud.model.OrderModel;
import edu.ijse.mvcCrud.dto.OrderDto;
import java.sql.SQLException;

/**
 *
 * @author KVN2004
 */
public class OrderController {
   OrderModel orderModel = new OrderModel();
   
   public String placeOrderSave(OrderDto orderDTO ) throws ClassNotFoundException, SQLException{
   
       return orderModel.placeOrderSave(orderDTO);
   
   }
}
