package edu.mum.cs544.service;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.repository.IBookDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService{

    @Resource
    private IBookDAO bookDAO;

    public void save(Book book){
        bookDAO.save(book);
    }

    public Book findById(Long id) {
        return bookDAO.getOne(id);
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }

}
