package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.FamilyRewards;
import com.example.catdemo.entity.FamilyRewardsExample;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2025-04-21 14:29
*/
@Mapper
public interface FamilyRewardsMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<FamilyRewards> selectByExample(FamilyRewardsExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    FamilyRewards selectByPrimaryKey(String id);

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
    int deleteByExample(FamilyRewardsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(FamilyRewards record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(FamilyRewards record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(FamilyRewardsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") FamilyRewards record, @Param("example") FamilyRewardsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") FamilyRewards record, @Param("example") FamilyRewardsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(FamilyRewards record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(FamilyRewards record);
}
