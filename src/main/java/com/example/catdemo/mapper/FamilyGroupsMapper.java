package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.FamilyGroups;
import com.example.catdemo.entity.FamilyGroupsExample;

/**
* 家庭群组表 Mapper
*
* @author zhanhuibin
* @since 2025-03-06 17:37
*/
@Mapper
public interface FamilyGroupsMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<FamilyGroups> selectByExampleWithBLOBs(FamilyGroupsExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<FamilyGroups> selectByExample(FamilyGroupsExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    FamilyGroups selectByPrimaryKey(String id);

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
    int deleteByExample(FamilyGroupsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(FamilyGroups record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(FamilyGroups record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(FamilyGroupsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") FamilyGroups record, @Param("example") FamilyGroupsExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") FamilyGroups record, @Param("example") FamilyGroupsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") FamilyGroups record, @Param("example") FamilyGroupsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(FamilyGroups record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(FamilyGroups record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(FamilyGroups record);
}
