package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.UserSubscription;
import com.example.catdemo.entity.UserSubscriptionExample;

/**
* 用户订阅表 Mapper
*
* @author zhanhuibin
* @since 2025-02-18 10:04
*/
@Mapper
public interface UserSubscriptionMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<UserSubscription> selectByExample(UserSubscriptionExample example);

    List<UserSubscription>  selectUserSubscriptionsWithFeature(UserSubscriptionExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    UserSubscription selectByPrimaryKey(String id);

    /**
     * 根据主键删除数据
     *
     * @param id
     * @return 数量
     */
    int deleteByPrimaryKey(String id);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(UserSubscriptionExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(UserSubscription record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(UserSubscription record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(UserSubscriptionExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") UserSubscription record, @Param("example") UserSubscriptionExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") UserSubscription record, @Param("example") UserSubscriptionExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(UserSubscription record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(UserSubscription record);
}
