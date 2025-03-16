package com.bookstore.app.controller;

import com.bookstore.app.model.Book;
import com.bookstore.app.repository.BookRepository;
import com.bookstore.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    //@io.swagger.v3.oas.annotations.parameters.RequestBody
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    //@io.swagger.v3.oas.annotations.parameters.RequestBody
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/book")
    public Book getBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        return bookService.getBookByTitleAndAuthor(title, author);
    }

    @GetMapping("/id")
    public Book getBookById(@RequestParam Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam Long id) {
        bookService.deleteBookById(id);
    }

    @DeleteMapping("/remove")
    public void deleteBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        bookService.deleteBook(bookService.getBookByTitleAndAuthor(title, author));
    }

    @PostMapping("/fetch")
    public List<Book> fetchAndSaveBooks() {
        return bookService.fetchAndSaveBooks();
    }
}
