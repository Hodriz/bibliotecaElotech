package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository <BookLoan , Long> {
}


