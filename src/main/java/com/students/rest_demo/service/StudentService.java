package com.students.rest_demo.service;

import com.students.rest_demo.model.Student;
import com.students.rest_demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class StudentService {
     StudentRepository studentRepository;
    public Student getstudentinfo(int userID){

        return studentRepository.findById(userID).get();

    }

    public void savestudents(Student student){

        this.studentRepository.save(student);


    }
}
