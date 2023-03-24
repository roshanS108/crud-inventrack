package com.example.crudinventrack.Service;

import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getBooks() {
        System.out.println("yes it this method is being called");
        return bookDAO.getAllBook();
    }
}
