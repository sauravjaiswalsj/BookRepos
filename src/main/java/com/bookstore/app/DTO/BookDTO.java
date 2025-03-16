package com.bookstore.app.DTO;

import lombok.Data;

@Data
class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private String price;
}