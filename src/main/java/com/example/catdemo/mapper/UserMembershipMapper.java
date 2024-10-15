package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.UserMembership;
import com.example.catdemo.entity.UserMembershipExample;

/**
* 用户会员表 Mapper
*
* @author zhanhuibin
* @since 2025-01-12 16:03
*/
@Mapper
public interface UserMembershipMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<UserMembership> selectByExample(UserMembershipExample example);

    /**
     * 根据主键id查询
     *
     * @param membershipId
     * @return 记录信息
     */
    UserMembership selectByPrimaryKey(String membershipId);

    /**
     * 根据主键删除数据
     *
     * @param membershipId
     * @return 数量
     */
    int deleteByPrimaryKey(String membershipId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(UserMembershipExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(UserMembership record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(UserMembership record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(UserMembershipExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") UserMembership record, @Param("example") UserMembershipExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") UserMembership record, @Param("example") UserMembershipExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(UserMembership record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(UserMembership record);
}
