package com.example.community.controller;

import com.example.community.repository.ArticleRepository;
import com.example.community.service.ArticleService;
import com.example.community.service.EnterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enters")
@RequiredArgsConstructor
public class EnterController {
  private final EnterService enterService;
  private final ArticleService articleService;

  @GetMapping
  public String listAllEnters(Model model){
    model.addAttribute("selected", null);
    model.addAttribute("enters", enterService.readAll());
    model.addAttribute("articles", articleService.readAllDesc());

    return "enters";
  }

  @GetMapping("/{id}")
  public String listOneEnter(
          @PathVariable("id")
          Long enterId,
          Model model
  ){
    model.addAttribute("enters", enterService.readAll());
    model.addAttribute("selected", enterService.readOne(enterId));

    return "enters";
  }
}
