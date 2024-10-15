package com.example.catdemo.service;


import com.example.catdemo.entity.Transfers;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2024-12-10 10:44
 */
public interface TransfersService {

    /**
     * 创建转账记录
     * @param transfer 转账信息
     * @return Response
     */
    Response createTransfer(Transfers transfer);

    /**
     * 根据 ID 删除转账记录
     * @param transferId 转账记录 ID
     * @return Response
     */
    Response deleteTransfer(String transferId);

    /**
     * 更新转账记录
     * @param transfer 转账信息
     * @return Response
     */
    Response updateTransfer(Transfers transfer);

    /**
     * 根据 ID 查询转账记录
     * @param transferId 转账记录 ID
     * @return Response
     */
    Response getTransferById(String transferId);

    /**
     * 查询所有转账记录
     * @return Response
     */
    Response getAllTransfers(RequestInfo requestInfo);

    /**
     * 批量添加转账记录
     * @param transfers 转账信息列表
     * @return Response
     */
    Response batchCreateTransfers(List<Transfers> transfers);

    /**
     * 批量删除转账记录
     * @param transferIds 转账记录 ID 列表
     * @return Response
     */
    Response batchDeleteTransfers(List<String> transferIds);
}

