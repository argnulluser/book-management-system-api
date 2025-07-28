package com.example.book_management_system_api.mapper;

import com.example.book_management_system_api.dto.BookDto;
import com.example.book_management_system_api.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toDto(Book book) {
        if (book == null) return null;

        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getPublishedDate()
        );
    }

    public Book toEntity(BookDto bookDto) {
        if (bookDto == null) return null;

        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setIsbn(bookDto.getIsbn());
        book.setPublishedDate(bookDto.getPublishedDate());

        return book;
    }
}

