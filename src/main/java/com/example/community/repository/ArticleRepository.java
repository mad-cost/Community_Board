package com.example.community.repository;

import com.example.community.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
 List<Article> findAllByOrderByIdDesc();
 List<Article> findByEnterIdOrderByIdDesc(Long enterId);
}
