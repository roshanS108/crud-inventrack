package com.example.crudinventrack.inventorymanagement.util;

public interface ServiceInventory {
    public String getBookDetails(String bookName, String authorName);

    public void removeBook(int isbn);
}
