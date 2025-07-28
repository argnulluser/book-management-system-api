package com.example.book_management_system_api.repository;

import com.example.book_management_system_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
