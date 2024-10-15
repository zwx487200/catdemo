package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.MembershipLevel;
import com.example.catdemo.entity.MembershipLevelExample;

/**
* 会员等级表 Mapper
*
* @author zhanhuibin
* @since 2025-01-12 16:03
*/
@Mapper
public interface MembershipLevelMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<MembershipLevel> selectByExampleWithBLOBs(MembershipLevelExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<MembershipLevel> selectByExample(MembershipLevelExample example);

    /**
     * 根据主键id查询
     *
     * @param levelId
     * @return 记录信息
     */
    MembershipLevel selectByPrimaryKey(String levelId);

    /**
     * 根据主键删除数据
     *
     * @param levelId
     * @return 数量
     */
    int deleteByPrimaryKey(String levelId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(MembershipLevelExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(MembershipLevel record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(MembershipLevel record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(MembershipLevelExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") MembershipLevel record, @Param("example") MembershipLevelExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") MembershipLevel record, @Param("example") MembershipLevelExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") MembershipLevel record, @Param("example") MembershipLevelExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(MembershipLevel record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(MembershipLevel record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(MembershipLevel record);
}
