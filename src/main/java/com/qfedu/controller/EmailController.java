package com.qfedu.controller;

import com.qfedu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/SendMail")
    @CrossOrigin
    public String sendMail(@RequestParam("email") String email) {
        if (emailService.sendMail(email)) {
            return "success";
        }
        return "failed";
    }
}
