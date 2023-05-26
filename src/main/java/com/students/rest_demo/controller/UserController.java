package com.students.rest_demo.controller;

import com.students.rest_demo.model.User;
import com.students.rest_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("")
////    public List<User> list() {
////
////        try {
////            List<User> user = userService.listAllUser();
////            return new ResponseEntity<User>(user, HttpStatus.OK);
////        } catch (NoSuchElementException e) {
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
////    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public String add(@RequestBody User user) {

        System.out.println(user);

        try
        {

            userService.saveUser(user);

      return "added"
;



        }
        catch (NoSuchElementException e){

        return "EEEEEEEEEEEEEEE";
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        userService.deleteUser(id);
    }
}