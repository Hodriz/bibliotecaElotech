package br.com.elotech.biblioteca.service;

import br.com.elotech.biblioteca.model.Author;
import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.repository.AuthorRepository;
import br.com.elotech.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor (Author author){
        return authorRepository.save(author);
    }

    public List<Author> authorList(){
        return authorRepository.findAll();
    }

    public Author findById(Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado!"));}

    public Author authorUpdate(long id, Author author){
        Author newAuthor=authorRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Autor não encontrado!!"));

        newAuthor.setName(author.getName());
        newAuthor.setLastName(author.getLastName());

        return authorRepository.save(newAuthor);
    }

    public String deleteAuthor (Long id){
        if (authorRepository.findById(id).isPresent()){
            authorRepository.deleteById(id);
        }else{throw new IllegalArgumentException("Autor não encontrado");}
        return "Autor deletado !!";
    }
}
