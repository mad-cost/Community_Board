package com.example.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Article {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  @Setter
  private String title;
  @Setter
  private String content;
  private String password;
  @Setter
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
