package com.Xunbao2026.Xunbao2026.repository;

import com.Xunbao2026.Xunbao2026.entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, String> {
    Optional<QuizSession> findBySessionCode(String sessionCode);
}
