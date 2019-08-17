package com.cwy.community.community.mapper;

import com.cwy.community.community.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void tes(){
        /*User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setName("wangwu");
        user.setAccountId("25252141");
       user.setGmeCreat(System.currentTimeMillis());
        user.setGmemodified(user.getGmeCreat());
        userMapper.insert(user);
        String token ="0a231558-a08a-4f93-aa34-e1d95bc465a5";
        User bytoken = userMapper.findBytoken(token);
        System.out.println(bytoken);*/
    }
}