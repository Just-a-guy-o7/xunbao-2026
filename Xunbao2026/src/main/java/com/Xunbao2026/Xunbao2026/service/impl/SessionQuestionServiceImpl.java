package com.Xunbao2026.Xunbao2026.service.impl;

import com.Xunbao2026.Xunbao2026.entity.SessionQuestion;
import com.Xunbao2026.Xunbao2026.repository.SessionQuestionRepository;
import com.Xunbao2026.Xunbao2026.service.SessionQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionQuestionServiceImpl implements SessionQuestionService {

    @Autowired
    private SessionQuestionRepository sessionQuestionRepository;

    @Override
    public SessionQuestion create(SessionQuestion sessionQuestion) {
        if (sessionQuestion.getId() == null) {
            sessionQuestion.setId(java.util.UUID.randomUUID().toString());
        }
        return sessionQuestionRepository.save(sessionQuestion);
    }

    @Override
    public SessionQuestion update(SessionQuestion sessionQuestion) {
        if (sessionQuestion.getId() == null || !sessionQuestionRepository.existsById(sessionQuestion.getId())) {
            throw new IllegalArgumentException("SessionQuestion with id " + sessionQuestion.getId() + " does not exist");
        }
        return sessionQuestionRepository.save(sessionQuestion);
    }

    @Override
    public Optional<SessionQuestion> getById(String id) {
        return sessionQuestionRepository.findById(id);
    }

    @Override
    public List<SessionQuestion> getAll() {
        return sessionQuestionRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (!sessionQuestionRepository.existsById(id)) {
            throw new IllegalArgumentException("SessionQuestion with id " + id + " does not exist");
        }
        sessionQuestionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return sessionQuestionRepository.existsById(id);
    }
}