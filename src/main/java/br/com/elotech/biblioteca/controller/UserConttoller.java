package br.com.elotech.biblioteca.controller;


import br.com.elotech.biblioteca.model.Book;
import br.com.elotech.biblioteca.model.User;
import br.com.elotech.biblioteca.service.BookService;
import br.com.elotech.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserConttoller {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> listUser(){
        return userService.userList();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.userUpdate(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        String message = userService.deleteUser(id);
        return ResponseEntity.ok(message);
    }

}
