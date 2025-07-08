package com.example.catdemo.service;

import com.example.catdemo.entity.WantToCook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

/**
 * 我想吃表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
public interface WantToCookService extends IService<WantToCook> {

    Response addWantToCook(WantToCook wantToCook);

    Response deleteWantToCook(Integer id);

    Response updateWantToCook(WantToCook wantToCook);

    Response getWantToCook(String id);

    Response getWantToCookList(RequestInfo requestInfo);

    Response updateIngredientsStatus(WantToCook wantToCook);


}
