package com.Xunbao2026.Xunbao2026.repository;

import com.Xunbao2026.Xunbao2026.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {
    List<Answer> findByQuestionId(String questionId);
}
