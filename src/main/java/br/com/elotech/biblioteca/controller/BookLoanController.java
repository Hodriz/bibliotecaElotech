package br.com.elotech.biblioteca.controller;

import br.com.elotech.biblioteca.model.BookLoan;
import br.com.elotech.biblioteca.service.BookLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class BookLoanController {

    @Autowired
    private BookLoanService bookLoanService;

    @PostMapping
    public BookLoan createBookLoan(@RequestParam Long bookId, @RequestParam Long userId){
        return  bookLoanService.createBookLoan(bookId, userId);
    }

    @GetMapping
    public List<BookLoan> getAllBookLoan(){
        return bookLoanService.AllBookLoan();
    }

    @GetMapping("/{id}")
    public BookLoan getBookLoanById(@PathVariable Long id){
        return bookLoanService.findById(id);
    }

    @PutMapping("/{id}/return")
    public void returnBookLoan(@PathVariable Long id){
        bookLoanService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBookLoan(@PathVariable Long id){
        return bookLoanService.deleteBook(id);
    }

}
