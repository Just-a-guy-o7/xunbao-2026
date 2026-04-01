package com.Xunbao2026.Xunbao2026.repository;

import com.Xunbao2026.Xunbao2026.entity.SessionParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionParticipantRepository extends JpaRepository<SessionParticipant, String> {
    List<SessionParticipant> findBySessionId(String sessionId);
    List<SessionParticipant> findByUserId(String userId);
}
