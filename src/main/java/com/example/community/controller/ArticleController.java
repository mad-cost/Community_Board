package com.example.community.controller;

import com.example.community.dto.ArticleDto;
import com.example.community.repository.EnterRepository;
import com.example.community.service.ArticleService;
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
          Long id,
          Model model
  ){
          model.addAttribute("article", articleService.readArticle(id));
          return "/article/read";
  }


}
