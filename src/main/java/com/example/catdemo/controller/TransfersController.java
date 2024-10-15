package com.example.catdemo.controller;

import com.example.catdemo.entity.Transfers;
import com.example.catdemo.service.TransfersService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-10 10:44
 */
@Api(tags = "前端控制器")
@RestController
@RequestMapping("/transfers")
public class TransfersController {

    @Autowired
    private TransfersService transfersService;

    @ApiOperation(value = "获取所有转账记录")
    @GetMapping
    public Response getAllTransfers(@RequestBody RequestInfo requestInfo) {
        return transfersService.getAllTransfers(requestInfo);
    }

    @ApiOperation(value = "根据ID获取转账记录")
    @GetMapping("/{id}")
    public Response getTransferById(@PathVariable String id) {
        return transfersService.getTransferById(id);
    }

    @ApiOperation(value = "新增转账记录")
    @PostMapping
    public Response createTransfer(@RequestBody Transfers transfer) {
        return transfersService.createTransfer(transfer);
    }

    @ApiOperation(value = "更新转账记录")
    @PutMapping
    public Response updateTransfer(@RequestBody Transfers transfer) {
        return transfersService.updateTransfer(transfer);
    }

    @ApiOperation(value = "删除转账记录")
    @DeleteMapping("/{id}")
    public Response deleteTransfer(@PathVariable String id) {
        return transfersService.deleteTransfer(id);
    }

//    @ApiOperation(value = "批量删除转账记录")
//    @DeleteMapping
//    public Response deleteTransfers(@RequestBody List<String> ids) {
//        transfersService.deleteTransfers(ids);
//        return ResponseEntity.noContent().build();
//    }
}

