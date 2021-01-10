package com.cloud.snow.service;

import com.cloud.snow.entity.User;

import java.util.List;

public interface UserService {

    List<User> findByName(String name);

    Integer addUser(User user);

    void loadUserToRedis();
}
