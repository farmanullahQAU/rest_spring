package com.students.rest_demo.controller;

import com.students.rest_demo.model.Student;
import com.students.rest_demo.model.User;
import com.students.rest_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;
@GetMapping({"userid"})
    public ResponseEntity<?> getUserInfo(@PathVariable int userid){

try
{

   Student student= studentService.getUserInfo(userid);
    return new ResponseEntity<Student>(student, HttpStatus.OK);

}
catch (NoSuchElementException err){
    return new ResponseEntity<Student>(HttpStatus.OK);
}

    }
@PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody Student student ){

    try{
        studentService.creatUser(student);

        return new ResponseEntity<String>("successsfull added", HttpStatus.OK);


    }
    catch (NoSuchElementException err){
        return new ResponseEntity<String>("error occured", HttpStatus.OK);
    }



    }
}
