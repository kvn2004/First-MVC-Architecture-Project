/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvcCrud.controller;



import edu.ijse.mvcCrud.dto.ItemDto;
import edu.ijse.mvcCrud.model.ItemModel;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author KVN2004
 */
public class ItemController {
    
    private final ItemModel item_model;

    public ItemController() {
       this.item_model = new ItemModel();
    }
   
     public ArrayList<ItemDto> getAllItems() throws SQLException, ClassNotFoundException{
        ArrayList<ItemDto> itemDtos = item_model.getAll();
        return itemDtos;
    }

    public String saveItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        String rsp =item_model.save(itemDto);
        return rsp;
    }

    public ItemDto searchItem(String ItmCode) throws SQLException, ClassNotFoundException {
         ItemDto dto = item_model.getItem(ItmCode);
        return dto;
    }

    public int updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        return item_model.updateItem(itemDto);
    }

    public int deleteItem(String ItmCode) throws SQLException, ClassNotFoundException {
        return item_model.deleteItem(ItmCode);
    }

  
}
