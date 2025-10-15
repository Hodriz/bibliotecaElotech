package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
