package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookLoanRepository extends JpaRepository <BookLoan , Long> {

}


