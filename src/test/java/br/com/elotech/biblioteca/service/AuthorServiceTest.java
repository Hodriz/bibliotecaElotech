package br.com.elotech.biblioteca.service;

import br.com.elotech.biblioteca.model.Author;
import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.Genre;
import br.com.elotech.biblioteca.model.Status;
import br.com.elotech.biblioteca.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author author;
    private Book book;
    private Genre genre;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

        genre=new Genre();
        genre.setGenre("Ficção");
        genre.setId(1L);


        book=new Book();
        book.setStatus(Status.FREE);
        book.setAuthor(author);
        book.setIsbn("456465126");
        book.setPublicationDate(LocalDate.ofEpochDay(2005-10-01));
        book.setTitle("Star Wars - Clone Wars");
        book.setId(1L);
        book.setCategory(genre);

        author=new Author();
        author.setId(1L);
        author.setName("Lucas");
        author.setLastName("George");
    }

    @Test
    void deveCriarAutor(){
        when(authorRepository.save(author)).thenReturn(author);
        Author resultado= authorService.createAuthor(author);
        assertEquals("George",resultado.getLastName());
    }

    @Test
    void deveListarAuthors(){
        List<Author> lista = Arrays.asList(author, new Author());
        when(authorRepository.findAll()).thenReturn(lista);

        List<Author> resultado = authorService.listAuthors();
        assertEquals(2,resultado.size());
    }
}
