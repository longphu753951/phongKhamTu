package com.phutl.repository;

import com.phutl.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers(String username);
}
