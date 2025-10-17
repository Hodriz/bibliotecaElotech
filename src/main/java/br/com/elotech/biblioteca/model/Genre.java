package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String genre;

    public Long getId() {
        return this.id;
    }

    public @NotNull String getGenre() {
        return this.genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGenre(@NotNull String genre) {
        this.genre = genre;
    }
}
