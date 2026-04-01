package com.Xunbao2026.Xunbao2026.service.impl;

import com.Xunbao2026.Xunbao2026.entity.Answer;
import com.Xunbao2026.Xunbao2026.repository.AnswerRepository;
import com.Xunbao2026.Xunbao2026.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer create(Answer answer) {
        if (answer.getId() == null) {
            answer.setId(java.util.UUID.randomUUID().toString());
        }
        return answerRepository.save(answer);
    }

    @Override
    public Answer update(Answer answer) {
        if (answer.getId() == null || !answerRepository.existsById(answer.getId())) {
            throw new IllegalArgumentException("Answer with id " + answer.getId() + " does not exist");
        }
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> getById(String id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (!answerRepository.existsById(id)) {
            throw new IllegalArgumentException("Answer with id " + id + " does not exist");
        }
        answerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return answerRepository.existsById(id);
    }
}