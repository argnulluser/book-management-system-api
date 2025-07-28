package com.example.book_management_system_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    Long id;
    String title;
    String author;
    String publisher;
    String isbn;
    String publishedDate;
}
