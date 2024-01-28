package com.example.community.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
  private Long enterId;

  public Article(String title, String content, String password, Long enterId) {
    this.title = title;
    this.content = content;
    this.password = password;
    this.enterId = enterId;
  }
}
