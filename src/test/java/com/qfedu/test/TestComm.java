package com.qfedu.test;

import com.qfedu.pojo.Comment;
import com.qfedu.service.ICommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/8/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestComm {
    @Resource
    private ICommentService iCommentService;
    @Test
    public void all(){
        List<Comment> comments = iCommentService.list();
        System.out.println(comments);
    }
}
