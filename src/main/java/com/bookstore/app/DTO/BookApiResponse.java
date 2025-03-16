package com.bookstore.app.DTO;

import com.bookstore.app.model.Book;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BookApiResponse {
    private List<BookDTO> books;

    public List<Book> toBooks() {
        books.forEach(System.out::println);
        return books.stream().map(b -> new Book(null, b.getTitle(), b.getAuthor(), 0, b.getIsbn(), null, 100)).collect(Collectors.toList());
    }
}

