package com.example.book_management_system_api.controller;

import com.example.book_management_system_api.dto.BookDto;
import com.example.book_management_system_api.entity.Book;
import com.example.book_management_system_api.mapper.BookMapper;
import com.example.book_management_system_api.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    BookService bookService;
    BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAllBooks(@RequestParam(required = false) String sortBy) {
        List<Book> books;
        if (sortBy != null) {
            books = bookService.getAllBooksSorted(sortBy);
        } else {
            books = bookService.getAllBooks();
        }
        return books.stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        var book = bookService.getBookById(id);
        if (book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookMapper.toDto(book));
    }

    @PutMapping
    public ResponseEntity<Void> updateBook(@RequestBody BookDto bookDto){
        var book = bookMapper.toEntity(bookDto);
        bookService.updateBook(book);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        var bookEntity = bookMapper.toEntity(bookDto);
        var savedBook = bookService.addBook(bookEntity);

        return new ResponseEntity<>(bookMapper.toDto(savedBook), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
       bookService.deleteBook(id);
       return ResponseEntity.ok().build();
    }
}