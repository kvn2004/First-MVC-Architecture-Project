/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.model;

import edu.ijse.mvcCrud.db.DBConnection;
import edu.ijse.mvcCrud.dto.OrderDetailDTO;
import edu.ijse.mvcCrud.dto.OrderDto;
import java.sql.*;

/**
 *
 * @author KVN2004
 */
public class OrderModel {

    private Connection connection;
    //private PreparedStatement preparedStatement;

    public String placeOrderSave(OrderDto orderDto) throws ClassNotFoundException, SQLException {
        connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            String orderSql = "INSERT INTO orders VALUES (?,?,?)";
            PreparedStatement orderStatement = connection.prepareStatement(orderSql);
            orderStatement.setString(1, orderDto.getOrderId());
            orderStatement.setString(2, orderDto.getOrderDate());
            orderStatement.setString(3, orderDto.getCustId());

            boolean isOrderSaved = orderStatement.executeUpdate() > 0;
            if (isOrderSaved) {
                boolean isOderDetailsSaved = true;

                for (OrderDetailDTO orderDetailDto : orderDto.getOrderDetailDtos()) {
                    String orderDetailSQL = "INSERT INTO orderdetail VALUES (?,?,?,?)";
                    PreparedStatement orderDetailStatement = connection.prepareStatement(orderDetailSQL);
                    orderDetailStatement.setString(1, orderDto.getOrderId());
                    orderDetailStatement.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatement.setInt(3, orderDetailDto.getQty());
                    orderDetailStatement.setDouble(4, orderDetailDto.getDiscount());

                    if (!(orderDetailStatement.executeUpdate() > 0)) {
                        isOderDetailsSaved = false;
                    }
                }
                if (isOderDetailsSaved) {
                    boolean isItemUpdated = true;

                    for (OrderDetailDTO orderDetailDto : orderDto.getOrderDetailDtos()) {
                        String itemUpdateSql = "UPDATE item SET QtyOnHand = QtyOnHand - ? WHERE ItemCode = ?";
                        PreparedStatement itemStatement = connection.prepareStatement(itemUpdateSql);
                        itemStatement.setInt(1, orderDetailDto.getQty());
                        itemStatement.setString(2, orderDetailDto.getItemCode());

                        if (!(itemStatement.executeUpdate() > 0)) {
                            isItemUpdated = false;
                        }
                    }
                    if (isItemUpdated) {
                        connection.commit();
                        return "saved";
                    } else {
                        connection.rollback();
                        return "Item Update ERROR!";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
