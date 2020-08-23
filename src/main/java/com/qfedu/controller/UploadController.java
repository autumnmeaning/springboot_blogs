package com.qfedu.controller;

import com.qfedu.util.QiniuUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class UploadController {

    @Resource
    private QiniuUtils qiniuUtils;

    @PostMapping("/AvatarUpload")
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        return qiniuUtils.upload(multipartFile);
    }
}
