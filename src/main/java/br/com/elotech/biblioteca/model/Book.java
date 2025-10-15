package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @NotBlank
    private String isbn;
    @NotNull
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @NotBlank
    private String category;
    @NotNull
    @Enumerated
    private Status status = Status.FREE;


    public Long getId() {
        return this.id;
    }

    public @NotBlank String getTitle() {
        return this.title;
    }

    public @NotNull Author getAuthor() {
        return this.author;
    }

    public @NotBlank String getIsbn() {
        return this.isbn;
    }

    public @NotNull LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public @NotBlank String getCategory() {
        return this.category;
    }

    public @NotNull Status getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public void setAuthor(@NotNull Author author) {
        this.author = author;
    }

    public void setIsbn(@NotBlank String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationDate(@NotNull LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setCategory(@NotBlank String category) {
        this.category = category;
    }

    public void setStatus(@NotNull Status status) {
        this.status = status;
    }
}
