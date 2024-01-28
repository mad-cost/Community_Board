package com.example.community.service;

import com.example.community.dto.ArticleDto;
import com.example.community.entity.Article;
import com.example.community.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
  private final ArticleRepository articleRepository;

  public List<ArticleDto> readAllDesc(){
    List<ArticleDto> articles = new ArrayList<>();
    for (Article article : articleRepository.findAllByOrderByIdDesc()){
      articles.add(ArticleDto.from(article));
    }
    return articles;
  }

}
