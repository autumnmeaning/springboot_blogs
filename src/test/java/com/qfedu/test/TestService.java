package com.qfedu.test;

import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestService {

    @Resource
    private IUserService userService;

    @Test
    public void test1() {
        List<User> list = userService.list();
        System.out.println(list);
    }
}