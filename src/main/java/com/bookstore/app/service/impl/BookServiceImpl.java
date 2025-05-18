package com.bookstore.app.service.impl;

import com.bookstore.app.DTO.BookApiResponse;
import com.bookstore.app.model.Book;
import com.bookstore.app.repository.BookRepository;
import com.bookstore.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    private final WebClient webClient = WebClient.create("https://api.itbook.store/1.0");
    @Autowired
    private BookRepository bookRepository;

    public List<Book> fetchAndSaveBooks(){
        List<Book> books =
                Objects.requireNonNull(webClient.get()
                                .uri("/new")
                                .retrieve()
                                .bodyToMono(BookApiResponse.class)
                                .block())
                        .toBooks();
        // same work could have been achieved by rest template
        return bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        String title = book.getTitle();
        String author = book.getAuthor();

        Book getBook = bookRepository.findByTitleAndAuthorFromBooks(title, author);
        if (getBook != null) {
            return null;
        }
        return bookRepository.save(book);
    }

    public Book getBookByTitleAndAuthor(String title, String author) {
        List<Book> books = getAllBooks();
        if (books != null) {
            return null;
        }

        return books.stream().filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author)).findFirst().get();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}