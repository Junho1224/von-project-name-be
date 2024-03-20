package com.von.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;// Controller는 Springframework에서 사용
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;// RestController는 Springboot에서 사용
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class HomeController {
    public final HomeService service;

    @RequestMapping("/")
    public String hello() {
        String s = service.test();
        return "Welcome to Spring Boot !";
    }

    @PostMapping("/")
    public Map<String, ?> name(@RequestBody Map<String, ?> map) {
        String name = (String) map.get("name");
        System.out.println("리퀘스트가 가져온 이름 : " + name);
        Map<String, String> resMap = new HashMap<>();
        resMap.put("name", "환영합니다" + name);
        return resMap;
    }

}
