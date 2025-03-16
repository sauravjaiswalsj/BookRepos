package com.bookstore.app.repository;

import com.bookstore.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b from Book as b where b.title=?1 AND b.author=?2")
    Book findByTitleAndAuthorFromBooks(String title, String author);
}
