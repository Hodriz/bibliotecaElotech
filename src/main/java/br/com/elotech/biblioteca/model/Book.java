package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private Author author;
    @NotBlank
    private String isbn;
    @NotNull
    @Column(name="publication_date")
    private LocalDate publicationDate;
    @NotBlank
    private String category;
    @OneToOne(mappedBy = "books")
    private List<Author> books=new ArrayList<>();

}
