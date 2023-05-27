package com.students.rest_demo.controller;

import com.students.rest_demo.model.User;
import com.students.rest_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

@GetMapping("")

public ResponseEntity<List<User>> allUsers(){


   List<User> list=   userService.getall();

    return new ResponseEntity<List<User>>(list,HttpStatus.NOT_FOUND);
}
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
    public ResponseEntity<String> add(@RequestBody User user) {


        try
        {

            userService.saveUser(user);


            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "wow added");
            return  new ResponseEntity<String>("added successfully",headers,HttpStatus.OK);




        }
        catch (NoSuchElementException e){


            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "foo");
            return  new ResponseEntity<String>("custom",headers,HttpStatus.NOT_FOUND);


        }
    }
    @PutMapping("/{userid}")
public ResponseEntity<Boolean> updateUser(@PathVariable Integer userid,@RequestBody User user){
        this.userService.updateUser(userid,user);
        return  new ResponseEntity<Boolean>(true,HttpStatus.OK);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

try{
    userService.deleteUser(id);
    return  new ResponseEntity<String>("deleted successfully",HttpStatus.OK);

}
catch (NoSuchElementException err){

    return  new ResponseEntity<String>("something went wrong",HttpStatus.NOT_FOUND);

}

}
}