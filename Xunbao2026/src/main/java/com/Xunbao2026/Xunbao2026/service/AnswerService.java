package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    Answer create(Answer answer);
    
    Answer update(Answer answer);
    
    Optional<Answer> getById(String id);
    
    List<Answer> getAll();
    
    void delete(String id);
    
    boolean existsById(String id);
}