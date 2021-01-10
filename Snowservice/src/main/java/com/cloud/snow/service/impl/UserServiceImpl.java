package com.cloud.snow.service.impl;

import com.cloud.snow.entity.User;
import com.cloud.snow.redis.RedisUtil;
import com.cloud.snow.repository.UserRepo;
import com.cloud.snow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public Integer addUser(User user) {
        User userm = userRepo.save(user);
        return userm.getId();
    }

    @Override
    public void loadUserToRedis() {
        for(User user:userRepo.findAll()){
            redisUtil.set(user.getName(),user);
        }
    }
}
