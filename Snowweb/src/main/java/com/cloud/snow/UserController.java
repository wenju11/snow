package com.cloud.snow;

import com.cloud.snow.entity.User;
import com.cloud.snow.redis.RedisUtil;
import com.cloud.snow.repository.UserRepo;
import com.cloud.snow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "snow")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam String name,@RequestParam String email,@RequestParam String passwd){

        User user= new User(name,email,passwd);
        String result="";
        try {
            userRepo.save(user).toString();
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"reqCode\":\"400\",\"reqMsg\":\"add user failure ...\"}";
            logger.error(result);
            return  result;
        }
        result = "{\"reqCode\":\"200\",\"reqMsg\":\"add user success\"}";
        return  result;
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<User> getAllUser(){
        logger.info("查询所有用户信息...");
        return userRepo.findAll();
    }

    @GetMapping("/findUsersByName")
    @ResponseBody
    public List<User> getUserByName(@RequestParam String name){
       return userRepo.findByName(name);
    }

    @GetMapping("/findByRedis")
    @ResponseBody
    public User getUserByRedis(@RequestParam String name){
        return (User) redisUtil.get(name);
    }

    @GetMapping("/initRedis")
    @ResponseBody
    public void initRedis(){
        userService.loadUserToRedis();
    }
}