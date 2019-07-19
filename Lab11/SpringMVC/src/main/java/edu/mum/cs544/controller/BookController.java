package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:add";
    }

    @GetMapping("/add")
    public String addBookPage(@ModelAttribute("book") Book book) {
        return "addBook";
    }

    @PostMapping("/add")
    public String saveBook(Book book, RedirectAttributes ra){
        bookService.save(book);
        ra.addFlashAttribute("book", book);
        return "redirect:details";
    }

    @GetMapping("/details")
    public String getDetail() {
        return "bookDetails";
    }

    @GetMapping("/library")
    public String getAllBook(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("message", "Found " + bookList.size() + " books");
        model.addAttribute("books", bookList);
        return "bookList";
    }


}
