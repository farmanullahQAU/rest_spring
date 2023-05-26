package com.students.rest_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "studentsTable")

public class Student {

    String name;

    public Student(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    String email;
    String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
