package com.example.community.service;

import com.example.community.dto.CommentDto;
import com.example.community.entity.Article;
import com.example.community.entity.Comment;
import com.example.community.repository.ArticleRepository;
import com.example.community.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final ArticleRepository articleRepository;
  private final CommentRepository commentRepository;

  public List<CommentDto> readComments(Long id){
    List<CommentDto> commentDtos = new ArrayList<>();
    for (Comment comments : commentRepository.findByArticleId(id)){
      commentDtos.add(CommentDto.from(comments));
    }
    return commentDtos;
  }
  public CommentDto creatComment(
          Long id,
          String content,
          String password
  ){
    Article article = articleRepository.findById(id).orElseThrow();
      Comment comment = new Comment(content, password, id);
      Comment commentSaved = commentRepository.save(comment);

      return CommentDto.from(commentSaved);


  }

  public void deleteComment(Long commentId, String password){
    Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new NoSuchElementException("삭제할 댓글이 존재하지 않습니다."));

    if (!comment.getPassword().equals(password)){
      throw new IllegalStateException("댓글의 비밀번호가 일치하지 않습니다.");
    }
    commentRepository.deleteById(commentId);
  }
}
