package com.example.crudinventrack.inventorymanagement.util;

public interface Product {
    String getName();
    double getPrice();
    int getQuantity();

    int updateQuantity(int newQuantity);

}
