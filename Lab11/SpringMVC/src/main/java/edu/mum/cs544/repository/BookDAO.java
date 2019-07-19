package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class BookDAO implements IBookDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public Book findById(Long id){
        return em.find(Book.class,id);
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("from Book",Book.class).getResultList();
    }
}
