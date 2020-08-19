package com.qfedu.service.impl;

import com.qfedu.service.IEmailService;
import com.qfedu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl implements IEmailService {

    @Value("${spring.mail.username}")
    private String sendName;

    @Resource
    private RedisUtil util;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(String mail) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendName);
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("验证码发送");
        int code = (int) ((Math.random() * 9 + 1) * 1000);
        String scode = String.valueOf(code);
        simpleMailMessage.setText(scode);
        try {
            javaMailSender.send(simpleMailMessage);
            util.set(mail, scode, 180);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
