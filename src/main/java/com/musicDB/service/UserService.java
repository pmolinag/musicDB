package com.musicDB.service;

import com.musicDB.entity.User;

public interface UserService {

    public User findByUsername(String username);
    public User register(User user);
}
