package br.com.elotech.biblioteca.repository;

import br.com.elotech.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
