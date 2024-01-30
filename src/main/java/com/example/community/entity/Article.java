package com.example.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Article {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String password;
  @ManyToOne
  @JoinColumn(name = "enterId")
  private Enter enter;

  public Article(String title, String content, String password, Enter enter) {
    this.title = title;
    this.content = content;
    this.password = password;
    this.enter = enter;
  }
}
