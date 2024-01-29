package com.example.community.controller;

import com.example.community.repository.EnterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
  private final EnterRepository enterRepository;

  @GetMapping("/new")
  public String create(
          Model model
  ){
    model.addAttribute("enters", enterRepository.findAll());
    return "article/create";
  }
}
