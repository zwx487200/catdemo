package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.entity.PocketbankExample;
import com.example.catdemo.mapper.PocketbankMapper;
import com.example.catdemo.service.PocketbankService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-09 15:12
 */
@Service
public class PocketbankServiceImpl implements PocketbankService {

    @Autowired
    private PocketbankMapper pocketbankMapper;

    /**
     * @param pocketbank 口袋银行记录
     * @return Response
     */
    @Override
    public Response addPocketbank(Pocketbank pocketbank) {
        int result = pocketbankMapper.insertSelective(pocketbank);
        if (result == 1) {
            return Response.success("添加成功");
        }
            return Response.error("添加失败");
    }

    /**
     * @param id 口袋银行记录ID
     * @return Response
     */
    @Override
    public Response deletePocketbank(String id) {
        int result = pocketbankMapper.deleteByPrimaryKey(id);
        if (result == 1) {
            return Response.success(id);
        }
        return Response.error("删除失败");
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Response getPocketbankByUserId(String userId) {
        PocketbankExample example = new PocketbankExample();
        PocketbankExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Pocketbank> pocketbanks = pocketbankMapper.selectByExample(example);
        if (pocketbanks.size() != 1) {
            return Response.error("用户不存在银行卡");
        }
        return Response.success(pocketbanks.get(0));
    }

    /**
     * @param pocketbank 口袋银行记录
     * @return Response
     */
    @Override
    public Response updatePocketbank(Pocketbank pocketbank) {
        int result = pocketbankMapper.updateByPrimaryKeySelective(pocketbank);
        if (result == 1) {
            return Response.success(pocketbank);
        }
        return Response.error("更新失败");
    }

    /**
     * @param id 口袋银行记录ID
     * @return Response
     */
    @Override
    public Response getPocketbankById(String id) {
        Pocketbank pocketbank = pocketbankMapper.selectByPrimaryKey(id);
        if (pocketbank != null) {
            return Response.success(pocketbank);
        }
        return Response.error("查询失败");
    }

    /**
     * @param requestInfo requestInfo
     * @return Response
     */
    @Override
    public Response getAllPocketbanks(RequestInfo requestInfo) {
        Pocketbank pocketbank = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<Pocketbank>() {
        });
        PocketbankExample example = new PocketbankExample();
        PocketbankExample.Criteria criteria = example.createCriteria();
        if (pocketbank != null) {
            if (StringUtils.isNotBlank(pocketbank.getUserId())){
                criteria.andUserIdEqualTo(pocketbank.getUserId());
            }
            if (StringUtils.isNotBlank(pocketbank.getStatus())){
                criteria.andStatusEqualTo(pocketbank.getStatus());
            }
        }

        List<Pocketbank> pocketbanks = pocketbankMapper.selectByExample(example);
        if (pocketbanks != null && !pocketbanks.isEmpty()) {
            return Response.success(pocketbanks);
        }
        return Response.error("查询失败");
    }

    /**
     * @param pocketbank
     * @return
     */
    @Override
    public Response getPocketbanksByUserId(Pocketbank pocketbank) {

        PocketbankExample example = new PocketbankExample();
        PocketbankExample.Criteria criteria = example.createCriteria();
        if (pocketbank != null) {
            if (StringUtils.isNotBlank(pocketbank.getUserId())){
                criteria.andUserIdEqualTo(pocketbank.getUserId());
            }
            if (StringUtils.isNotBlank(pocketbank.getStatus())){
                criteria.andStatusEqualTo(pocketbank.getStatus());
            }
        }

        List<Pocketbank> pocketbanks = pocketbankMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(pocketbanks) && pocketbanks.size() == 1) {
            return Response.success(pocketbanks);
        }
        return Response.error("您还没有零用钱账户，您可以移步到账单功能，添加一笔收入，同时选择同步到零用钱余额");
    }

    /**
     * @param pocketbanks 口袋银行记录列表
     * @return Response
     */
    @Override
    public Response addBatchPocketbanks(List<Pocketbank> pocketbanks) {
        return null;
    }

    /**
     * @param ids 口袋银行记录ID列表
     * @return Response
     */
    @Override
    public Response deleteBatchPocketbanks(List<String> ids) {
        return null;
    }

    public List<Pocketbank> getPocketbanksWithFixedBalance() {
        PocketbankExample example = new PocketbankExample();
        example.createCriteria().andFixedBalanceGreaterThan(BigDecimal.valueOf(0)).andStatusEqualTo("01");
        return pocketbankMapper.selectByExample(example);
    }
}
