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
@RequestMapping("/articles/{articleId}/comments")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  public String createComment(
     @PathVariable("articleId")
     Long articleId,
     @RequestParam("content")
     String content,
     @RequestParam("password")
     String password
  ){
    CommentDto comment = commentService.creatComment(articleId, content, password);
    return "redirect:/articles/" + comment.getArticleId();
  }

  @PostMapping("/{commentId}/delete")
  public String deleteComment(
          @PathVariable("articleId")
          Long articleId,
          @PathVariable("commentId")
          Long commentId,
          @RequestParam("password")
          String password
  ){
      commentService.deleteComment(commentId, password);
      return "redirect:/articles/" + articleId;
  }

}
