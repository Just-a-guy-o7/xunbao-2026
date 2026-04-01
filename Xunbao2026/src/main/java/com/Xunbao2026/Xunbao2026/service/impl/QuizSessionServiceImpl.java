package com.Xunbao2026.Xunbao2026.service.impl;

import com.Xunbao2026.Xunbao2026.entity.QuizSession;
import com.Xunbao2026.Xunbao2026.repository.QuizSessionRepository;
import com.Xunbao2026.Xunbao2026.service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizSessionServiceImpl implements QuizSessionService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Override
    public QuizSession create(QuizSession quizSession) {
        if (quizSession.getId() == null) {
            quizSession.setId(java.util.UUID.randomUUID().toString());
        }
        return quizSessionRepository.save(quizSession);
    }

    @Override
    public QuizSession update(QuizSession quizSession) {
        if (quizSession.getId() == null || !quizSessionRepository.existsById(quizSession.getId())) {
            throw new IllegalArgumentException("QuizSession with id " + quizSession.getId() + " does not exist");
        }
        return quizSessionRepository.save(quizSession);
    }

    @Override
    public Optional<QuizSession> getById(String id) {
        return quizSessionRepository.findById(id);
    }

    @Override
    public List<QuizSession> getAll() {
        return quizSessionRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (!quizSessionRepository.existsById(id)) {
            throw new IllegalArgumentException("QuizSession with id " + id + " does not exist");
        }
        quizSessionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return quizSessionRepository.existsById(id);
    }
}