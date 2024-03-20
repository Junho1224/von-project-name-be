package com.von.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @GetMapping("/login")
    public String hello(){
        return "welcom";
    }

    @PostMapping("/username")
    public Map<String,?> name(@RequestBody Map<String,?> map){
        String name = (String)map.get("username");
        System.out.println("request가 가져온 이름 : "+name);
        Map<String,String> respMap = new HashMap<>();
        respMap.put("username","환영환영."+name);
        return respMap;
    }


    public Map<String,?> save(@RequestBody Map<String,?> map) {
                return null;
    }

    public Map<String,?> login(@RequestBody Map<String,?> map) {
        return null;
    }

    public Map<String,?> changePassword(@RequestBody Map<String,?> map) {
        return null;
    }

    public Map<String,?> delete(@RequestBody Map<String,?> map) {
        return null;
    }

    public Map<String,?> findUsersByName(@RequestBody Map<String,?> map) {
        return null;
    }

    public Map<String,?> findUsersByJob(@RequestBody Map<String,?> map) {
        return null;
    }


    public Map<String,?> count() {
        return null;
    }

    public Map<String,?> findUsers() throws SQLException {
        return null;
    }

    public void createTable() throws SQLException {
    }

    public void deleteTable() throws SQLException {
    }


    public Map<String,?> getOne(@RequestBody Map<String,?> map) {
        return null;
    }

    public Map<String,?> findUser(@RequestBody Map<String,?> map) {
        return null;
    }
}
