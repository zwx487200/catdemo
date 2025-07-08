package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.PointsChangeLog;
import com.example.catdemo.entity.PointsChangeLogExample;

/**
* 积分流水表 Mapper
*
* @author zhanhuibin
* @since 2025-04-14 09:13
*/
@Mapper
public interface PointsChangeLogMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<PointsChangeLog> selectByExample(PointsChangeLogExample example);

    /**
     * 根据主键id查询
     *
     * @param logId
     * @return 记录信息
     */
    PointsChangeLog selectByPrimaryKey(String logId);

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
    int deleteByExample(PointsChangeLogExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(PointsChangeLog record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(PointsChangeLog record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(PointsChangeLogExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") PointsChangeLog record, @Param("example") PointsChangeLogExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") PointsChangeLog record, @Param("example") PointsChangeLogExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(PointsChangeLog record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(PointsChangeLog record);
}
