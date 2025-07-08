package com.example.catdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.Billinfo;
import com.example.catdemo.entity.CookingSteps;
import com.example.catdemo.entity.UserBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 账单表 Mapper 接口
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-11-17
 */
@Mapper
public interface BillinfoMapper  extends BaseMapper<Billinfo> {

    int insertBillinfo(Billinfo billinfo);
    int updateBillinfoById(Billinfo billinfo);
    Billinfo selectBillinfoById(String id);
    List<Billinfo> selectAllBillinfo(Billinfo billinfo);
    int deleteBillinfoById(String id);
    List<UserBill> selectBillinfosByUserId(UserBill billinfo);

}
