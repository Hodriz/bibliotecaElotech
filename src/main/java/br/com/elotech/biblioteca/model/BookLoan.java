package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
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
    @OneToMany
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
    @NotNull
    private Status status;


    public void setLoanDate(@NotNull LocalDate loanDate) {
        if(loanDate.isEqual(LocalDate.now()) || loanDate.isAfter(LocalDate.now())) {
            this.loanDate = loanDate;}
        else { throw new IllegalArgumentException(" Data de Cadastro não pode ser menor que a data atual!!");}
    }

    public void setLoanReturn(@NotNull LocalDate loanReturn) {
        if(loanReturn.isAfter(LocalDate.now())) {
            this.loanReturn = loanReturn;}
        else { throw new IllegalArgumentException(" Data de Cadastro não pode ser menor que a data atual!!");}
    }
}
