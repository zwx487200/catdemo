package com.example.catdemo.service;


import com.example.catdemo.entity.Babynoteinfo;

import java.util.List;

/**
 * 宝宝记 服务类接口
 *
 * @author zhanhuibin
 * @since 2024-12-04 16:54
 */
public interface BabynoteinfoService {

    // 添加宝宝记录
    void addBabynoteinfo(Babynoteinfo babynoteinfo);

    // 删除宝宝记录
    void deleteBabynoteinfo(String id);

    // 更新宝宝记录
    void updateBabynoteinfo(Babynoteinfo babynoteinfo);

    // 根据ID查询宝宝记录
    Babynoteinfo getBabynoteinfoById(String id);

    // 查询所有宝宝记录
    List<Babynoteinfo> getAllBabynoteinfos(Babynoteinfo babynoteinfo);

    // 批量添加宝宝记录
    void batchAddBabynoteinfos(List<Babynoteinfo> babynoteinfos);

    // 批量删除宝宝记录
    void batchDeleteBabynoteinfos(List<String> ids);

    // 批量更新宝宝记录
    void batchUpdateBabynoteinfos(List<Babynoteinfo> babynoteinfos);
}

