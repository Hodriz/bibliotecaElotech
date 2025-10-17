package br.com.elotech.biblioteca.service;

import br.com.elotech.biblioteca.model.User;
import br.com.elotech.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser (User user){
        user.setRegistrationDate(LocalDate.now());
        return userRepository.save(user);
    }

    public List<User> userList(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));}

    public User userUpdate(long id, User user){
        User newUser=userRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Usuario não encontrado!!"));

        newUser.setName(user.getName());
        newUser.setTel(user.getTel());
        newUser.setEmail(user.getEmail());

        return userRepository.save(newUser);
    }

    public String deleteUser (Long id){
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else{throw new IllegalArgumentException("Usuaário não encontrado");}
        return "Usuário deletado !!";
    }
}
