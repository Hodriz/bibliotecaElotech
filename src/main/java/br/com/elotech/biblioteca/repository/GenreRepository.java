package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
