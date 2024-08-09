package com.example.betterReads.book_module.repository;

import com.example.betterReads.book_module.model.entity.Book;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    void deleteById(@Nonnull String id);

}
