package com.von.api.article;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.von.api.user.User;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    
} 