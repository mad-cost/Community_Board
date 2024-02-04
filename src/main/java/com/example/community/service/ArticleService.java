package com.example.community.service;

import com.example.community.dto.ArticleDto;
import com.example.community.entity.Article;
import com.example.community.entity.Enter;
import com.example.community.repository.ArticleRepository;
import com.example.community.repository.EnterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArticleService {
  private final EnterRepository enterRepository;
  private final ArticleRepository articleRepository;

  public List<ArticleDto> readAllDesc(){
    List<ArticleDto> articles = new ArrayList<>();
    for (Article article : articleRepository.findAllByOrderByIdDesc()){
      articles.add(ArticleDto.from(article));
    }
    return articles;
  }

  public List<ArticleDto> readArticleEnterIdDesc(Long enterId){
    List<ArticleDto> articles = new ArrayList<>();
    for (Article article : articleRepository.findByEnterIdOrderByIdDesc(enterId)){
      articles.add(ArticleDto.from(article));
    }
    return articles;
  }

  public ArticleDto create(
          String title,
          String content,
          String password,
          Long enterId
  ) {
    Enter enter = enterRepository.findById(enterId)
            .orElseThrow();
    Article article = new Article(title, content, password, enter);
    return ArticleDto.from(articleRepository.save(article));
  }

  public ArticleDto readArticle(Long articleId){
    return ArticleDto.from(articleRepository.findById(articleId)
            .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다 articleId = " + articleId)));
  }

  public void delete(Long id, String password){
    Article article = articleRepository.findById(id)
            .orElseThrow();
    if (article.getPassword().equals(password)){
      articleRepository.delete(article);
    }
  }

  public void update(
          Long articleId,
          String title,
          String content,
          String password,
          Long enterId){
    Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new NoSuchElementException("게시글을 찾을수가 없습니다."));
    if (article.getPassword().equals(password)){
      article.setTitle(title);
      article.setContent(content);
      Enter enter = enterRepository.findById(enterId)
              .orElseThrow();
      article.setEnter(enter);
    }
    ArticleDto.from(articleRepository.save(article));
  }
}