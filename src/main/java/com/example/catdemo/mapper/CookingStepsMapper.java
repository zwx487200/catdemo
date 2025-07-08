package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.CookingSteps;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.CookingStepsExample;

/**
* 烹饪步骤表 Mapper
*
* @author zhanhuibin
* @since 2025-06-03 11:15
*/
@Mapper
public interface CookingStepsMapper extends BaseMapper<CookingSteps> {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<CookingSteps> selectByExampleWithBLOBs(CookingStepsExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<CookingSteps> selectByExample(CookingStepsExample example);

    /**
     * 根据主键id查询
     *
     * @param cookingStepId
     * @return 记录信息
     */
    CookingSteps selectByPrimaryKey(String cookingStepId);

    /**
     * 根据主键删除数据
     *
     * @param cookingStepId
     * @return 数量
     */
    int deleteByPrimaryKey(String cookingStepId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(CookingStepsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(CookingSteps record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(CookingSteps record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(CookingStepsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") CookingSteps record, @Param("example") CookingStepsExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") CookingSteps record, @Param("example") CookingStepsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") CookingSteps record, @Param("example") CookingStepsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(CookingSteps record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(CookingSteps record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(CookingSteps record);
}
