package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
