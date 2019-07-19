package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Book;

import java.util.List;

public interface IBookDAO {
    public void save(Book book);
    public Book findById(Long id);
    public List<Book> findAll();
}
