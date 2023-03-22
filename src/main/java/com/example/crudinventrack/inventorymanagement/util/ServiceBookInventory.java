package com.example.crudinventrack.inventorymanagement.util;

public interface ServiceBookInventory {
    public String getBookDetails(String bookName, String authorName);

    public void removeBook(int isbn);
}
