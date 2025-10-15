package br.com.elotech.biblioteca.service;

import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.User;
import br.com.elotech.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook (Book book){
        return bookRepository.save(book);
    }

    public List<Book> bookList(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado!"));}

    public Book bookUpdate(long id, Book book){
        Book newBook=bookRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Book não encontrado!!"));

        newBook.setAuthor(book.getAuthor());
        newBook.setIsbn(book.getIsbn());
        newBook.setCategory(book.getCategory());
        newBook.setTitle(book.getTitle());
        newBook.setPublicationDate(book.getPublicationDate());


        return bookRepository.save(newBook);
    }

    public String deleteBook (Long id){
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
        }else{throw new IllegalArgumentException("Livro não encontrado");}
        return "Livro deletado !!";
    }
}
