package com.bookstore.app.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "book")
@Schema(description = "Details about a book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generates unique
    @Schema(description = "The unique ID of the book", example = "1")
    private Long id;
    @Schema(description = "The title of the book", example = "Spring Boot in Action")
    private String title;

    @Schema(description = "The author of the book", example = "Craig Walls")
    private String author;

    @Schema(description = "The price of the book", example = "29.99")
    private double price;

    @Schema(description = "The isbn of the book", example = "32312")
    private String isbn;

    @Schema(description = "The publisher of the book", example = "O'rielly")
    private String publisher;

    @Schema(description = "The number of the book", example = "50")
    private int stock;

    public Book(Long id, String title, String author, double price, String isbn, String publisher, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.publisher = publisher;
        this.stock = stock;
    }
}