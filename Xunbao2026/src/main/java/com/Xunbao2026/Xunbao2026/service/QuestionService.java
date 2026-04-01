package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question create(Question question);
    Question update(Question question);
    Optional<Question> getById(String id);
    List<Question> getAll();
    void delete(String id);
    boolean existsById(String id);
}