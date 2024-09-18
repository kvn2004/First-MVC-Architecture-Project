/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.dto;

/**
 *
 * @author KVN2004
 */
public class OrderDetailDTO {

    private String itemCode;
    private int qty;
    private double discount;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itemCode, int qty, double discount) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.discount = discount;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "itemCode=" + itemCode + ", qty=" + qty + ", discount=" + discount + '}';
    }

}
