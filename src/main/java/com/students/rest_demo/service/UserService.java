package com.students.rest_demo.service;


import com.students.rest_demo.exceptions.NotFoundException;
import com.students.rest_demo.model.User;
import com.students.rest_demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
if(
        userRepository.findById(id).isEmpty()
){

    throw  new NotFoundException("user not exist with");
}
else{

  return  userRepository.findById(id).get();

}





    }

    public void updateUser(Integer id,User user
    ){

        User usr= this.userRepository.findById(id).get();

        usr.setFirstName(user.getFirstName());
        usr.setLastName(user.getLastName());
        userRepository.save(usr);


    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getall() {

        if(
         userRepository.findAll().isEmpty()

        ) throw new NotFoundException("no user found");
return   userRepository.findAll();
    }
}