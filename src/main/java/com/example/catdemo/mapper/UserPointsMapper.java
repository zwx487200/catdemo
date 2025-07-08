package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.UserPoints;
import com.example.catdemo.entity.UserPointsExample;

/**
* 用户积分主表 Mapper
*
* @author zhanhuibin
* @since 2025-04-14 09:13
*/
@Mapper
public interface UserPointsMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<UserPoints> selectByExample(UserPointsExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    UserPoints selectByPrimaryKey(String id);

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
    int deleteByExample(UserPointsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(UserPoints record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(UserPoints record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(UserPointsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") UserPoints record, @Param("example") UserPointsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") UserPoints record, @Param("example") UserPointsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(UserPoints record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(UserPoints record);
}
