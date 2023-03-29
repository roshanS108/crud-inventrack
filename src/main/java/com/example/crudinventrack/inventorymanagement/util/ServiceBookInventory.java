package com.example.crudinventrack.inventorymanagement.util;

import com.example.crudinventrack.entity.Book;

import java.util.List;

public interface ServiceBookInventory {
    String getBookDetails(String bookName, String authorName);

    void removeBook();

    List<Book> getBookCollection();

//    void testing();

}
