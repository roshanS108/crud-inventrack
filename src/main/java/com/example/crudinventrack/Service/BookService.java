package com.example.crudinventrack.Service;

import com.example.crudinventrack.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBooksDataById(Integer id);

    void updateTheQuantity(Book theBook);

}
