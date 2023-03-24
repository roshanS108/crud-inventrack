package com.example.crudinventrack.dao;
import com.example.crudinventrack.entity.Book;
import com.example.crudinventrack.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BookDAOImpl implements BookDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public BookDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void saveBook(Book theBook) {
        Book manageBook = entityManager.merge(theBook);
        entityManager.persist(manageBook);

    }

    @Override
    public Book readBookData(Integer id) {
        return entityManager.find(Book.class, id);
    }

}
