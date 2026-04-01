package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.QuizSession;

import java.util.List;
import java.util.Optional;

public interface QuizSessionService {
    QuizSession create(QuizSession quizSession);
    QuizSession update(QuizSession quizSession);
    Optional<QuizSession> getById(String id);
    List<QuizSession> getAll();
    void delete(String id);
    boolean existsById(String id);
}