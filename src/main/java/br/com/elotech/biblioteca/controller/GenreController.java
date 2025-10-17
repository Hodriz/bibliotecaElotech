package br.com.elotech.biblioteca.controller;


import br.com.elotech.biblioteca.model.Genre;
import br.com.elotech.biblioteca.model.User;
import br.com.elotech.biblioteca.service.GenreService;
import br.com.elotech.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {


    @Autowired
    private GenreService genreService;

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }

    @GetMapping
    public List<Genre> listGenre(){
        return genreService.listGenre();
    }

    @GetMapping("/{id}")
    public Genre findUserById(@PathVariable Long id){
        return genreService.findById(id);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable long id, @RequestBody Genre genre){
        return genreService.genreUpdate(id, genre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        String message = genreService.deleteGenre(id);
        return ResponseEntity.ok(message);
    }

}
