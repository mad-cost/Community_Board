package com.example.community.controller;

import com.example.community.dto.CommentDto;
import com.example.community.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/articles/{articleId}/comment")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  public String createComment(
     @PathVariable("articleId")
     Long id,
     @RequestParam("content")
     String content,
     @RequestParam("password")
     String password
  ){
    CommentDto comment = commentService.creatComment(id, content, password);
    return "redirect:/articles/" + comment.getArticleId();
  }

}
