package com.students.rest_demo.controller;

import com.students.rest_demo.model.User;
import com.students.rest_demo.responseHandler.ResponseHandler;
import com.students.rest_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

@GetMapping("")

public ResponseEntity<Object> allUsers(){


//   List<User> list=   userService.getall();

return  ResponseHandler.responseBuilder("list of users",HttpStatus.OK,this.userService.getall());
}
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id) {


return   ResponseHandler.responseBuilder("user detaials",HttpStatus.OK, userService.getUser(id));

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