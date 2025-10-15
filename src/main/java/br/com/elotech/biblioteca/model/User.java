package br.com.elotech.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
        if (registrationDate.isEqual(LocalDate.now()))
           {this.registrationDate=registrationDate;}
        else {throw new IllegalArgumentException("Data de cadastro deve ser a data atual!");}
    }

}
