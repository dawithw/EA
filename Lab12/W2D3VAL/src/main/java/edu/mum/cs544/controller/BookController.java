package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:library";
    }

    @GetMapping("/add")
    public String addBookPage(Model model) {
        if (!model.containsAttribute("book"))
            model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes ra){
        if (result.hasErrors()) {
            ra.addFlashAttribute("org.springframework.validation.BindingResult.book",result);
            ra.addFlashAttribute("book", book);
            return "redirect:/add";
        }
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
