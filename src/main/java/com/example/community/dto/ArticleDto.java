package com.example.community.dto;

import com.example.community.entity.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleDto {
  private Long id;
  private String title;
  private String content;
  private String password;
  private Long enterId;

  public ArticleDto(Long id, String title, String content, String password, Long enterId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.password = password;
    this.enterId = enterId;
  }

  public static ArticleDto from(Article entity){
    return new ArticleDto(
            entity.getId(),
            entity.getTitle(),
            entity.getContent(),
            entity.getPassword(),
            entity.getEnterId()
    );
  }

}
