package com.example.crudinventrack.dao;
import com.example.crudinventrack.entity.Book;
import com.example.crudinventrack.entity.Customer;

import java.util.List;

public interface BookDAO {

    void saveBook(Book theBook);

    Book readBookData(Integer id);

    List<Book> getAllBook();

    Book findByIsbn(Integer id);

    void update(Book theBook);

}
