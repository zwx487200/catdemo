package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Feature;
import com.example.catdemo.entity.FeatureExample;

/**
* 功能表 Mapper
*
* @author zhanhuibin
* @since 2025-02-18 09:57
*/
@Mapper
public interface FeatureMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<Feature> selectByExampleWithBLOBs(FeatureExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Feature> selectByExample(FeatureExample example);

    /**
     * 根据主键id查询
     *
     * @param featureId
     * @return 记录信息
     */
    Feature selectByPrimaryKey(String featureId);

    /**
     * 根据主键删除数据
     *
     * @param featureId
     * @return 数量
     */
    int deleteByPrimaryKey(String featureId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(FeatureExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Feature record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Feature record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(FeatureExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Feature record, @Param("example") FeatureExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") Feature record, @Param("example") FeatureExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Feature record, @Param("example") FeatureExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Feature record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(Feature record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Feature record);
}
