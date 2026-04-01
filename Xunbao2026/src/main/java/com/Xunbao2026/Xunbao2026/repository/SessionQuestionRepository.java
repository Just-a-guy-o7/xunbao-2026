package com.Xunbao2026.Xunbao2026.repository;

import com.Xunbao2026.Xunbao2026.entity.SessionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionQuestionRepository extends JpaRepository<SessionQuestion, String> {
    List<SessionQuestion> findBySessionId(String sessionId);
    List<SessionQuestion> findByQuestionId(String questionId);
}
