package br.com.elotech.biblioteca.controller;

import br.com.elotech.biblioteca.model.Author;
import br.com.elotech.biblioteca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @GetMapping
    public List<Author> listAuthor(){
        return authorService.listAuthors();
    }

    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author author){
        return authorService.authorUpdate(id, author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        String message = authorService.deleteAuthor(id);
        return ResponseEntity.ok(message);
    }

}
