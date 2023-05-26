package com.students.rest_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "studentsTable")

public class Student {

    String name;

    public Student(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    String email;
    int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
