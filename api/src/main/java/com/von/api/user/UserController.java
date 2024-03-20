package com.von.api.user;

import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Map<String, ?> userName(@RequestBody Map<String, ?> paramMap) {
        String username = (String) paramMap.get("username");
        System.out.println("리퀘스트가 가져온 이름 : " + username);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("username", " : " + username);
        return resMap;
    }


    public Map<String,?> count() {
        Map<String,String> map = new HashMap<>();
        return map;
        
    }

    public Map<String,?> save(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;

    }

    public Map<String,?> updatePassword(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String, ?> getUserMap() {
        Map<String,String> map = new HashMap<>();
    
        return map;

    }
    public Map<String,?> addUser() {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String,?> login(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String,?> findUser(@RequestBody Map<String, ?> paramMap) {

        Map<String,String> map = new HashMap<>();
        return map;

    }
    public Map<String,?> existsById(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }
    public Map<String,?> findUsersByName(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }
    public Map<String, ?> findUsersByNameFromMap(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String,?> findUsersByJob(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String, ?> findUsersByJobFromMap(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

   
    public Map<String,?> getOne(@RequestBody Map<String, ?> paramMap) {
        Map<String,String> map = new HashMap<>();
        return map;
    }

    public Map<String, ?> getUserID() {
        Map<String,String> map = new HashMap<>();
        return map;

    }
    
    public Map<String,?> findUsers() throws SQLException {
        Map<String,String> map = new HashMap<>();
        return map;
    }


    public Map<String,?> createUsers() throws SQLException {
        Map<String,String> map = new HashMap<>();
        return map;
    }



}