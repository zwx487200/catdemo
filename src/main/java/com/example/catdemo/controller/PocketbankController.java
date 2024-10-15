package com.example.catdemo.controller;

import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.service.PocketbankService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-09 15:12
 */
@Api(tags = "前端控制器")
@RestController
@RequestMapping("/pocketbank")
public class PocketbankController {

    @Autowired
    private PocketbankService pocketbankService;

    /**
     * 添加口袋银行记录
     *
     * @param pocketbank 口袋银行记录
     * @return 添加结果
     */
    @ApiOperation(value = "添加口袋银行记录")
    @PostMapping
    public Response addPocketbank(@RequestBody Pocketbank pocketbank) {
        return pocketbankService.addPocketbank(pocketbank);
    }

    /**
     * 删除口袋银行记录
     *
     * @param id 口袋银行记录ID
     * @return 删除结果
     */
    @ApiOperation(value = "删除口袋银行记录")
    @DeleteMapping("/{id}")
    public Response deletePocketbank(@PathVariable String id) {
        return pocketbankService.deletePocketbank(id);
    }

    /**
     * 更新口袋银行记录
     *
     * @param pocketbank 口袋银行记录
     * @return 更新结果
     */
    @ApiOperation(value = "更新口袋银行记录")
    @PutMapping
    public Response updatePocketbank(@RequestBody Pocketbank pocketbank) {
        return pocketbankService.updatePocketbank(pocketbank);
    }

    /**
     * 根据ID查找口袋银行记录
     *
     * @param id 口袋银行记录ID
     * @return 口袋银行记录
     */
    @ApiOperation(value = "根据ID查找口袋银行记录")
    @GetMapping("/{id}")
    public Response getPocketbankById(@PathVariable String id) {
        return pocketbankService.getPocketbankById(id);
    }

    /**
     * 查询所有口袋银行记录
     *
     * @return 口袋银行记录列表
     */
    @ApiOperation(value = "查询所有口袋银行记录")
    @PostMapping("/queryPocketbankByCondition")
    public Response queryPocketbankByCondition(@RequestBody RequestInfo requestInfo) {
        return pocketbankService.getAllPocketbanks(requestInfo);
    }

    /**
     * 查询所有口袋银行记录
     *
     * @return 口袋银行记录列表
     */
    @ApiOperation(value = "查询所有口袋银行记录")
    @PostMapping("/queryPocketbankByUserId")
    public Response queryPocketbankByUserId(@RequestBody  Pocketbank pocketbank) {
        return pocketbankService.getPocketbanksByUserId(pocketbank);
    }

    /**
     * 批量添加口袋银行记录
     *
     * @param pocketbanks 口袋银行记录列表
     * @return 添加结果
     */
    @ApiOperation(value = "批量添加口袋银行记录")
    @PostMapping("/batch")
    public Response addBatchPocketbanks(@RequestBody List<Pocketbank> pocketbanks) {
        return pocketbankService.addBatchPocketbanks(pocketbanks);
    }

    /**
     * 批量删除口袋银行记录
     *
     * @param ids 口袋银行记录ID列表
     * @return 删除结果
     */
    @ApiOperation(value = "批量删除口袋银行记录")
    @DeleteMapping("/batch")
    public Response deleteBatchPocketbanks(@RequestBody List<String> ids) {
        return pocketbankService.deleteBatchPocketbanks(ids);
    }
}

