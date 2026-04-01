package com.Xunbao2026.Xunbao2026.repository;

import com.Xunbao2026.Xunbao2026.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
}
