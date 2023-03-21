package com.example.crudinventrack.dao;
import com.example.crudinventrack.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public BookDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void saveBook(Book theBook) {
        entityManager.persist(theBook);
    }
}
