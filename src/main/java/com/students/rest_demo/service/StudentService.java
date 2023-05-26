package com.students.rest_demo.service;

import com.students.rest_demo.model.Student;
import com.students.rest_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
     StudentRepository studentRepository;
    public Student getUserInfo(int userID){

        return studentRepository.findById(userID).get();

    }

    public void creatUser(Student student){

        this.studentRepository.save(student);


    }
}
