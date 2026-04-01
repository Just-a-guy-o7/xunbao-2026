package com.Xunbao2026.Xunbao2026.service.impl;

import com.Xunbao2026.Xunbao2026.entity.Question;
import com.Xunbao2026.Xunbao2026.repository.QuestionRepository;
import com.Xunbao2026.Xunbao2026.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question create(Question question) {
        if (question.getId() == null) {
            question.setId(java.util.UUID.randomUUID().toString());
        }
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        if (question.getId() == null || !questionRepository.existsById(question.getId())) {
            throw new IllegalArgumentException("Question with id " + question.getId() + " does not exist");
        }
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> getById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (!questionRepository.existsById(id)) {
            throw new IllegalArgumentException("Question with id " + id + " does not exist");
        }
        questionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return questionRepository.existsById(id);
    }
}