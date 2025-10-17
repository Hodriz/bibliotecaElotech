package br.com.elotech.biblioteca.service;


import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.BookLoan;
import br.com.elotech.biblioteca.model.Status;
import br.com.elotech.biblioteca.model.User;
import br.com.elotech.biblioteca.repository.BookLoanRepository;
import br.com.elotech.biblioteca.repository.BookRepository;
import br.com.elotech.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookLoanService {

    @Autowired
    private BookLoanRepository bookLoanRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    private LocalDate date;

    public BookLoan createBookLoan (Long bookId, Long userId){

        Book book = bookRepository.findById(bookId).orElseThrow(() ->new IllegalArgumentException("livro não encontrado!!"));
        User user = userRepository.findById(userId).orElseThrow(() ->new IllegalArgumentException("usuario não encontrado!!"));
        BookLoan loan=new BookLoan();

        if(book.getStatus()!= Status.FREE){
            System.out.println("Livro indisponível!!!");
        }else{
            loan.setUser(user);
            loan.setBook(book);
            loan.setLoanDate(date.now());
            loan.setLoanReturn(date.now().plusDays(7));
        }
        book.setStatus(Status.BORROWED);

        return bookLoanRepository.save(loan);
    }

    public List<BookLoan> AllBookLoan(){
        return bookLoanRepository.findAll();
    }

    public BookLoan findById(Long id){
        return bookLoanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado!"));}

//    public BookLoan bookLoanUpdate(Long loanId, BookLoan updateLoan){
//        BookLoan newBookLoan=bookLoanRepository.findById(loanId)
//                .orElseThrow(() ->new IllegalArgumentException("Empréstimo não encontrado!!"));
//        newBookLoan.setLoanReturn(updateLoan.getLoanReturn());
//        newBookLoan.setBook(updateLoan.getBook());
//        newBookLoan.setUser(updateLoan.getUser());
//
//        return bookLoanRepository.save(updateLoan);
//    }

    public void returnBook(Long id){
        BookLoan loan =bookLoanRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Empréstimo não encontrado"));
        Book book =loan.getBook();
        book.setStatus(Status.FREE);
        bookRepository.save(book);

        loan.setLoanReturn(LocalDate.now());
        bookLoanRepository.save(loan);
    }

    public String deleteBookLoan (Long id){
        if (bookLoanRepository.findById(id).isPresent()){
            BookLoan loan =bookLoanRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Empréstimo não encontrado"));
            Book book =loan.getBook();
            bookRepository.getById(book.getId());
            book.setStatus(Status.FREE);
            bookLoanRepository.deleteById(id);

        }else{throw new IllegalArgumentException("registro não encontrado");}
        return "registro deletado !!";
    }
}
