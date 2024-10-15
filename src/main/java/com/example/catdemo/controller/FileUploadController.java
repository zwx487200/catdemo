package com.example.catdemo.controller;

import com.example.catdemo.entity.UploadFile;
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
    final static String FILEURL= "D:\\my-vue3-ts-elmplus-demo\\src\\image";

    @PostMapping("/upload")
    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file) {
        UploadFile uploadFile = new UploadFile();
        try {
            File dir = new File(FILEURL);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String type = StringUtils.getFilenameExtension(fileName);
            uploadFile.setType(type);
            String originFileName = UUID.randomUUID()+ "." + type;
            file.transferTo(new File(FILEURL+"\\"+originFileName));
            uploadFile.setName(file.getOriginalFilename());
            uploadFile.setUrl(originFileName);
            uploadFile.setSize(file.getSize());
            return ResponseEntity.ok(uploadFile);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("文件上传失败：" + e.getMessage());
        }
    }
}