package com.qfedu.controller;


import com.qfedu.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 54110 on 2020/8/18.
 */
@RestController
@CrossOrigin
public class StaticThymeLeafController {

    @Autowired
    private TemplateEngine templateEngine;
    @Resource
    private QiniuUtils qiniuUtils;
    @PostMapping("/Create")
    public String createStatic(@RequestBody Map<String, String> map){
        String article = map.get("html");
        Context context = new Context();
        context.setVariable("article",article);
        String aStatic = templateEngine.process("article", context);
        System.out.println(aStatic);
        String string = qiniuUtils.uploadAsString(aStatic);
        System.out.println(string);
        return string;
    }
}
