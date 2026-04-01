package com.Xunbao2026.Xunbao2026.service;

import com.Xunbao2026.Xunbao2026.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    User update(User user);
    Optional<User> getById(String id);
    List<User> getAll();
    void delete(String id);
    boolean existsById(String id);
}