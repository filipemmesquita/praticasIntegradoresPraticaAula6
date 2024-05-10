package com.filipem.projeto.pr1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipem.projeto.pr1.entity.User;
import com.filipem.projeto.pr1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        if(!users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id){
        User user = userService.getById(id);
        if(user!=null)
            return new ResponseEntity<>(user,HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        if(updatedUser != null)
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
        else    
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id){
        if(userService.deleteUser(id))
            return new ResponseEntity<>(true,HttpStatus.OK);
        else   
            return new ResponseEntity<>(false,HttpStatus.OK);
    }
}
