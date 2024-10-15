package com.example.catdemo.controller;

import com.example.catdemo.entity.Babynoteinfo;
import com.example.catdemo.service.BabynoteinfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宝宝记 前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-04 16:54
 */
@Api(tags = "宝宝记前端控制器")
@RestController
@RequestMapping("/babynoteinfo")
public class BabynoteinfoController {

    @Autowired
    private BabynoteinfoService babynoteinfoService;

    // 添加宝宝记录
    @PostMapping
    public ResponseEntity<Void> addBabynoteinfo(@RequestBody Babynoteinfo babynoteinfo) {
        babynoteinfoService.addBabynoteinfo(babynoteinfo);
        return ResponseEntity.ok().build();
    }

    // 删除宝宝记录
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBabynoteinfo(@PathVariable String id) {
        babynoteinfoService.deleteBabynoteinfo(id);
        return ResponseEntity.ok().build();
    }

    // 更新宝宝记录
    @PutMapping
    public ResponseEntity<Void> updateBabynoteinfo(@RequestBody Babynoteinfo babynoteinfo) {
        babynoteinfoService.updateBabynoteinfo(babynoteinfo);
        return ResponseEntity.ok().build();
    }

    // 根据ID查询宝宝记录
    @GetMapping("/{id}")
    public ResponseEntity<Babynoteinfo> getBabynoteinfoById(@PathVariable String id) {
        Babynoteinfo babynoteinfo = babynoteinfoService.getBabynoteinfoById(id);
        return ResponseEntity.ok(babynoteinfo);
    }

    // 查询所有宝宝记录
    @GetMapping
    public ResponseEntity<List<Babynoteinfo>> getAllBabynoteinfos(@RequestBody Babynoteinfo babynoteinfo) {
        List<Babynoteinfo> babynoteinfos = babynoteinfoService.getAllBabynoteinfos(babynoteinfo);
        return ResponseEntity.ok(babynoteinfos);
    }

    // 批量添加宝宝记录
    @PostMapping("/batch")
    public ResponseEntity<Void> batchAddBabynoteinfos(@RequestBody List<Babynoteinfo> babynoteinfos) {
        babynoteinfoService.batchAddBabynoteinfos(babynoteinfos);
        return ResponseEntity.ok().build();
    }

    // 批量删除宝宝记录
    @DeleteMapping("/batch")
    public ResponseEntity<Void> batchDeleteBabynoteinfos(@RequestBody List<String> ids) {
        babynoteinfoService.batchDeleteBabynoteinfos(ids);
        return ResponseEntity.ok().build();
    }

    // 批量更新宝宝记录
    @PutMapping("/batch")
    public ResponseEntity<Void> batchUpdateBabynoteinfos(@RequestBody List<Babynoteinfo> babynoteinfos) {
        babynoteinfoService.batchUpdateBabynoteinfos(babynoteinfos);
        return ResponseEntity.ok().build();
    }
}

