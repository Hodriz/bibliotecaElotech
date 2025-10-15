package br.com.elotech.biblioteca.controller;


import br.com.elotech.biblioteca.model.Author;
import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.service.AuthorService;
import br.com.elotech.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> listBook(){
        return bookService.bookList();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book){
        return bookService.bookUpdate(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        String message = bookService.deleteBook(id);
        return ResponseEntity.ok(message);
    }

}
