package com.example.community.dto;

import com.example.community.entity.Enter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnterDto {
  private Long id;
  private String name;


  public EnterDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static EnterDto from(Enter entity){
    return new EnterDto(
            entity.getId(),
            entity.getName()
    );
  }

}
