package com.example.catdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author jennyzhuzhu
 * @since 2024-09-03
 */
@RestController
@RequestMapping("/file")
@Repository
@CrossOrigin
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // 这里可以添加你的文件保存逻辑
            byte[] bytes = file.getBytes();
            //把文件的内容存储到本地磁盘上
            String originFileName = file.getOriginalFilename();
            file.transferTo(new File("D:\\wenjianshangchuandemo\\"+originFileName));

            return ResponseEntity.ok("文件上传成功：" + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("文件上传失败：" + e.getMessage());
        }
    }
}