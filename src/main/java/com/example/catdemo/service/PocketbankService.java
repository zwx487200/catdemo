package com.example.catdemo.service;

import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import java.util.List;

/**
 * 口袋银行服务接口
 *
 * @author zhanhuibin
 * @since 2024-12-09 15:12
 */
public interface PocketbankService {

    /**
     * 添加口袋银行记录
     *
     * @param pocketbank 口袋银行记录
     * @return 添加结果
     */
    Response addPocketbank(Pocketbank pocketbank);

    /**
     * 删除口袋银行记录
     *
     * @param id 口袋银行记录ID
     * @return 删除结果
     */
    Response deletePocketbank(String id);

    /**
     * 根据用户id查询口袋银行记录
     */
    Response getPocketbankByUserId(String userId);

    /**
     * 更新口袋银行记录
     *
     * @param pocketbank 口袋银行记录
     * @return 更新结果
     */
    Response updatePocketbank(Pocketbank pocketbank);

    /**
     * 根据ID查找口袋银行记录
     *
     * @param id 口袋银行记录ID
     * @return 口袋银行记录
     */
    Response getPocketbankById(String id);

    /**
     * 查询所有口袋银行记录
     *
     * @return 口袋银行记录列表
     */
    Response getAllPocketbanks(RequestInfo requestInfo);

    /**
     * 查询口袋银行记录
     *
     * @return 口袋银行记录列表
     */
    Response getPocketbanksByUserId(Pocketbank pocketbank);

    /**
     * 批量添加口袋银行记录
     *
     * @param pocketbanks 口袋银行记录列表
     * @return 添加结果
     */
    Response addBatchPocketbanks(List<Pocketbank> pocketbanks);

    /**
     * 批量删除口袋银行记录
     *
     * @param ids 口袋银行记录ID列表
     * @return 删除结果
     */
    Response deleteBatchPocketbanks(List<String> ids);
}

