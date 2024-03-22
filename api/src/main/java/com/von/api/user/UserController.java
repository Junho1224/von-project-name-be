package com.von.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;

    @PostMapping("/api/login")
    public Map<String, ?> userName(@RequestBody Map<String, ?> paramMap) {
        String username = (String) paramMap.get("username");
        System.out.println("리퀘스트가 가져온 이름 : " + username);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("username", " : " + username);
        return resMap;
    }


    @PostMapping(path = "/api/users")
    public Map<String, ?> join(@RequestBody Map<String, ?> paramMap) {
        User newUser = User.builder()
                .username((String) paramMap.get("username"))
                .password((String) paramMap.get("password"))
                .name((String) paramMap.get("name"))
                .phone((String) paramMap.get("phone"))
                .job((String) paramMap.get("job"))
                .height(Double.parseDouble((String) paramMap.get("height")))
                .weight(Double.parseDouble((String) paramMap.get("weight")))
                .build();
                System.out.println("DB에 저장된 User 정보" + newUser);

        repo.save(newUser); 
        System.out.println("성공?");

        Map<String, Messenger> map = new HashMap<>();
        map.put("result", Messenger.SUCCESS);

        return map;
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
