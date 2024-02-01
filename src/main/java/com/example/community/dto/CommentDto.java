package com.example.community.dto;

import com.example.community.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {
  private Long id;

  private String content;

  private String password;

  private Long articleId;

  public CommentDto(Long id, String content, String password, Long articleId) {
    this.id = id;
    this.content = content;
    this.password = password;
    this.articleId = articleId;
  }

  public static CommentDto from(Comment entity){
    return new CommentDto(
            entity.getId(),
            entity.getContent(),
            entity.getPassword(),
            entity.getArticleId()
    );
  }
}
