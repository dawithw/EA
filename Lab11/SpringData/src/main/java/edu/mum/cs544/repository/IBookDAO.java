package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookDAO extends JpaRepository<Book,Long> {
}
