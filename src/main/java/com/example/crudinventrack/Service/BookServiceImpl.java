package com.example.crudinventrack.Service;

import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getBooks() {

        return bookDAO.getAllBook();
    }

    @Override
    public Book getBooksDataById(Integer id) {
        return bookDAO.findByIsbn(id);
    }

    @Override
    public void updateTheQuantity(Book theBook) {
        bookDAO.update(theBook);
    }

    @Override
    public void deleteTheBook(Integer id) {
        bookDAO.delete(id);
    }

}
