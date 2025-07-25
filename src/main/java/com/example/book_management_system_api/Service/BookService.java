package com.example.book_management_system_api.Service;

import com.example.book_management_system_api.Repository.BookRepository;
import com.example.book_management_system_api.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
