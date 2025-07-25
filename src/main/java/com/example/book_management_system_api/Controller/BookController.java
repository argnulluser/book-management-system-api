package com.example.book_management_system_api.Controller;

import com.example.book_management_system_api.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    BookService bookService;

    @RequestMapping("")
    public Object getAllBooks(){
        return bookService.getAllBooks();
    }


}
