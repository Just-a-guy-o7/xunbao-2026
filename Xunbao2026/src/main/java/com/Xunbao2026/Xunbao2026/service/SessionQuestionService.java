package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.SessionQuestion;

import java.util.List;
import java.util.Optional;

public interface SessionQuestionService {
    SessionQuestion create(SessionQuestion sessionQuestion);
    SessionQuestion update(SessionQuestion sessionQuestion);
    Optional<SessionQuestion> getById(String id);
    List<SessionQuestion> getAll();
    void delete(String id);
    boolean existsById(String id);
}