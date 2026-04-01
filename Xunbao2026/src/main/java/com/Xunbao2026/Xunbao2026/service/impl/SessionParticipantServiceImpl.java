package com.Xunbao2026.Xunbao2026.service.impl;

import com.Xunbao2026.Xunbao2026.entity.SessionParticipant;
import com.Xunbao2026.Xunbao2026.repository.SessionParticipantRepository;
import com.Xunbao2026.Xunbao2026.service.SessionParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionParticipantServiceImpl implements SessionParticipantService {

    @Autowired
    private SessionParticipantRepository sessionParticipantRepository;

    @Override
    public SessionParticipant create(SessionParticipant sessionParticipant) {
        if (sessionParticipant.getId() == null) {
            sessionParticipant.setId(java.util.UUID.randomUUID().toString());
        }
        return sessionParticipantRepository.save(sessionParticipant);
    }

    @Override
    public SessionParticipant update(SessionParticipant sessionParticipant) {
        if (sessionParticipant.getId() == null || !sessionParticipantRepository.existsById(sessionParticipant.getId())) {
            throw new IllegalArgumentException("SessionParticipant with id " + sessionParticipant.getId() + " does not exist");
        }
        return sessionParticipantRepository.save(sessionParticipant);
    }

    @Override
    public Optional<SessionParticipant> getById(String id) {
        return sessionParticipantRepository.findById(id);
    }

    @Override
    public List<SessionParticipant> getAll() {
        return sessionParticipantRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (!sessionParticipantRepository.existsById(id)) {
            throw new IllegalArgumentException("SessionParticipant with id " + id + " does not exist");
        }
        sessionParticipantRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return sessionParticipantRepository.existsById(id);
    }
}