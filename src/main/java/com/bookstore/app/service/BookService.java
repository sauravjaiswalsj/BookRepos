package com.bookstore.app.service;

import com.bookstore.app.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    Book getBookById(Long id);
    Book getBookByTitleAndAuthor(String title, String author);
    Book updateBook(Book book);
    void deleteBook(Book book);
    void deleteBookById(Long id);
    List<Book> fetchAndSaveBooks();
}
