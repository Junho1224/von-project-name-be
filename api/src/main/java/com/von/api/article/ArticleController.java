package com.von.api.article;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.von.api.enums.Messenger;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServiceImpl service;
 
    @GetMapping("/api/articles")
    public Map<?,?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("message", Messenger.SUCCESS);
        @SuppressAjWarnings("unchecked")

        
        // list.add(Article.builder()
        // .id(1L)
        // .title("청사초롱 불밝혀라")
        // .content("잊었던 낭군 다시온다")
        // .writer("늴 니리리야")
        // .registerDate("닐 리리야 니나노")
        // .build());
        List<Article> list = new ArrayList<>();
        list = service.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈 : "+list.size());
        map.put("result",list);
        return map;
    }
}
