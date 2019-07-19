package edu.mum.cs544.service;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
@Transactional
public class BookService{

    @Resource
    private BookDAO bookDAO;

    public void save(Book book){
        bookDAO.save(book);
    }

    public Book findById(Long id) {
        return bookDAO.findById(id);
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }

}
