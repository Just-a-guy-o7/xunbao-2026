package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.SessionParticipant;

import java.util.List;
import java.util.Optional;

public interface SessionParticipantService {
    SessionParticipant create(SessionParticipant sessionParticipant);
    SessionParticipant update(SessionParticipant sessionParticipant);
    Optional<SessionParticipant> getById(String id);
    List<SessionParticipant> getAll();
    void delete(String id);
    boolean existsById(String id);
}