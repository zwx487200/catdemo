package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.MembershipLog;
import com.example.catdemo.entity.MembershipLogExample;

/**
* 会员日志表 Mapper
*
* @author zhanhuibin
* @since 2025-01-12 16:03
*/
@Mapper
public interface MembershipLogMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<MembershipLog> selectByExample(MembershipLogExample example);

    /**
     * 根据主键id查询
     *
     * @param logId
     * @return 记录信息
     */
    MembershipLog selectByPrimaryKey(String logId);

    /**
     * 根据主键删除数据
     *
     * @param logId
     * @return 数量
     */
    int deleteByPrimaryKey(String logId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(MembershipLogExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(MembershipLog record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(MembershipLog record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(MembershipLogExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") MembershipLog record, @Param("example") MembershipLogExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") MembershipLog record, @Param("example") MembershipLogExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(MembershipLog record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(MembershipLog record);
}
