package com.example.catdemo.service;

import com.example.catdemo.entity.Anniversary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 纪念日表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface AnniversaryService extends IService<Anniversary> {

    Response addAnniversary(Anniversary anniversary);

    Response updateAnniversary(Anniversary anniversary);

    Response deleteAnniversary(String anniversaryId);

    Response getAnniversaries(RequestInfo requestInfo);

    Response batchAddAnniversaries(List<Anniversary> anniversaries);

    Response getAnniversaryById(String id);




}
