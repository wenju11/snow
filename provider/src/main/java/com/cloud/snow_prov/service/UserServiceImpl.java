package com.cloud.rain_prov.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cloud.rain_lib.IUserService;
import org.springframework.stereotype.Component;

/**
 * @Author: yanchen
 * @DateTime: 2021/1/25 9:20 下午
 * @Description: TODO
 */

@Component
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public String hello() {
        return "prov2-----springBoot 整合dubbo！！！";
    }
}
