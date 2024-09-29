package com.example.catdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

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
            // 判断文件夹是否存在，没有则新增
            File dir = new File("D:\\wenjianshangchuandemo");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 将文件名修改为UUID()生成的
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String originFileName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(fileName);;
            //把文件的内容存储到本地磁盘上
            //String originFileName = file.getOriginalFilename();
            file.transferTo(new File("D:\\wenjianshangchuandemo\\"+originFileName));

            return ResponseEntity.ok(originFileName);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("文件上传失败：" + e.getMessage());
        }
    }
}