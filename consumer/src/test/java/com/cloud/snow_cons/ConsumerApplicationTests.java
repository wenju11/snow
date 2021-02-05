package com.cloud.snow_cons;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cloud.snow_lib.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    @Reference
    private IUserService userService;

    @Test
    public void context(){
        System.out.println("....1111....");
        System.out.println(userService.hello());
    }
}