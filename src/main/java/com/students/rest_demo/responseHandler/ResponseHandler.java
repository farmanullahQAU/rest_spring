package com.students.rest_demo.responseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {


    public static ResponseEntity<Object> responseBuilder(String message ,HttpStatus status,Object responseObject){

 Map<String,Object> responseMap= new HashMap<>();

 responseMap.put("message",message);
 responseMap.put("data",responseObject);
 responseMap.put("status",status);

 return new ResponseEntity<>(responseMap,status);

    }
}
