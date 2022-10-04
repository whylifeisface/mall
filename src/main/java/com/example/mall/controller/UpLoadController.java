package com.example.mall.controller;

import com.example.mall.service.UpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UpLoadController {

    @Autowired
    private UpLoadService upLoadService;

    public String upload(MultipartFile file) throws IOException {


        return  upLoadService.upLoad(file.getInputStream(),file.getOriginalFilename());
    }
}
