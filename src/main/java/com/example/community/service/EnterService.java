package com.example.community.service;

import com.example.community.dto.EnterDto;
import com.example.community.entity.Enter;
import com.example.community.repository.EnterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnterService {


  private final EnterRepository enterRepository;

  public List<EnterDto> readAll(){
    List<EnterDto> enterDtos = new ArrayList<>();
    for (Enter enter : enterRepository.findAll()){
      enterDtos.add(EnterDto.from(enter));
    }
    return enterDtos;
  }

  public EnterDto readOne(Long enterId){
    Optional<Enter> optionalEnter
            = enterRepository.findById(enterId);
    if (optionalEnter.isEmpty()){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return EnterDto.from(optionalEnter.get());
  }
}