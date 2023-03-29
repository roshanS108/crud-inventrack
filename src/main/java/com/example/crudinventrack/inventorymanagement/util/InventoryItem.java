package com.example.crudinventrack.inventorymanagement.util;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Random;

@MappedSuperclass
public  class InventoryItem{

    @Column(name = "name_of_Book")
    private String name;

    @Column(name = "price_of_Book")
    private double price;

    @Column(name = "quantity")
    private int quantity;
    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public InventoryItem(){

    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void updatePrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
