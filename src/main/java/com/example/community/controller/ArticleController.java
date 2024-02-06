package com.example.community.controller;

import com.example.community.dto.ArticleDto;
import com.example.community.repository.EnterRepository;
import com.example.community.service.ArticleService;
import com.example.community.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
  private final EnterRepository enterRepository;
  private final ArticleService articleService;
  private final CommentService commentService;
  @GetMapping("/new")
  public String create(
          Model model
  ){
    model.addAttribute("enters", enterRepository.findAll());
    return "article/create";
  }

  @PostMapping
  public String creatArticle(
          @RequestParam("title")
          String title,
          @RequestParam("content")
          String content,
          @RequestParam("password")
          String password,
          @RequestParam("enter-id")
          Long enterId
  ){
    ArticleDto newId = articleService.create(title, content, password, enterId);
    return "redirect:/articles/" + newId.getId();
  }

  @GetMapping("/{articleId}")
  public String readArticle(
          @PathVariable("articleId")
          Long articleId,
          Model model
  ){
    model.addAttribute("article", articleService.readArticle(articleId));
    model.addAttribute("comments", commentService.readComments(articleId));
    return "article/read";
  }
  @PostMapping("/{articleId}/delete")
  public String deleteArticle(
          @PathVariable("articleId")
          Long articleId,
          @RequestParam
          String password
  ){
    articleService.delete(articleId, password);
    return "redirect:/enters";
  }

  @GetMapping("/{articleId}/edit")
  public String editArticle(
          @PathVariable("articleId")
          Long articleId,
          Model model
  ){
    model.addAttribute("article", articleService.readArticle(articleId));
    model.addAttribute("enters", enterRepository.findAll());

    return "article/edit";
  }

  @PostMapping("/{articleId}/update")
  public String updateArticle(
          @PathVariable("articleId")
          Long articleId,
          @RequestParam("title")
          String title,
          @RequestParam("content")
          String content,
          @RequestParam("password")
          String password,
          @RequestParam("enter-id")
          Long enterId
  ){
    articleService.update(articleId, title, content, password, enterId);
    return "redirect:/articles/" + articleId;
  }
}