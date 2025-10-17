package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;
    @NotNull
    @Column(name = "loan_date")
    private LocalDate loanDate;
    @NotNull
    @Column(name = "loan_return")
    private LocalDate loanReturn;


    public void setLoanDate(@NotNull LocalDate loanDate) {
        if (loanDate.isEqual(LocalDate.now()) || loanDate.isAfter(LocalDate.now())) {
            this.loanDate = loanDate;
        } else {
            throw new IllegalArgumentException(" Data de Cadastro não pode ser menor que a data atual!!");
        }
    }

    public void setLoanReturn(@NotNull LocalDate loanReturn) {
        if (!loanReturn.isBefore(LocalDate.now())) {
            this.loanReturn = loanReturn;
        } else {
            throw new IllegalArgumentException(" Data de Cadastro não pode ser menor que a data atual!!");
        }
    }

    public Long getId() {
        return this.id;
    }

    public @NotNull User getUser() {
        return this.user;
    }

    public @NotNull Book getBook() {
        return this.book;
    }

    public @NotNull LocalDate getLoanDate() {
        return this.loanDate;
    }

    public @NotNull LocalDate getLoanReturn() {
        return this.loanReturn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    public void setBook(@NotNull Book book) {
        this.book = book;
    }
}
