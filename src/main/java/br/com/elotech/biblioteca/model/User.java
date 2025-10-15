package br.com.elotech.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private LocalDate registrationDate;
    @NotBlank
    private String tel;


    public void setRegistrationDate(@NotNull LocalDate registrationDate) {
        if (registrationDate.isEqual(LocalDate.now())) {
            this.registrationDate = registrationDate;
        } else {
            throw new IllegalArgumentException("Data de cadastro deve ser a data atual!");
        }
    }


    public Long getId() {
        return this.id;
    }

    public @NotBlank String getName() {
        return this.name;
    }

    public @NotBlank @Email String getEmail() {
        return this.email;
    }

    public @NotNull LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public @NotBlank String getTel() {
        return this.tel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public void setTel(@NotBlank String tel) {
        this.tel = tel;
    }
}
